package org.outsrcd.vagabond.core;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.outsrcd.vagabond.core.model.Nmaprun;
import org.springframework.stereotype.Component;

@Component
public class NmapRoute extends RouteBuilder {
  
  private static final String BASE_EXEC_STRING = "--oX - -T";
  private static final String NETMASK_HEADER = "netmask";
  
  @Override
  public void configure() throws Exception {       
    
    
    JaxbDataFormat jaxb = new JaxbDataFormat("org.outsrcd.vagabond.core.model");
    
      restConfiguration()
        .component("jetty")
        .port(1337)
        .contextPath("api")
        .bindingMode(RestBindingMode.json_xml);                 
      
      rest("/nmap")
        .get("/{url}")
          .param().name("timing-template").type(RestParamType.query).defaultValue("3").endParam()
          //.param().name("detect-all").type(RestParamType.query).dataType("boolean").endParam()
          .produces("application/json,application/xml")
          .type(Nmaprun.class)
          .to("direct:nmap-scan")
        .get("/{url}/{netmask}")
          .param().name("timing-template").type(RestParamType.query).defaultValue("3").endParam()
          //.param().name("A").type(RestParamType.query).defaultValue("3").endParam()
          .produces("application/json,application/xml")
          .type(Nmaprun.class)
          .to("direct:nmap-scan");     

      // Jetty interprets URLEncoded '/', so delimit so just make command/netmask to separate params
      from("direct:nmap-scan")
        .choice().when(simple("${headers.netmask} == null"))
          .setHeader(NETMASK_HEADER, constant("32"))
        .end()          
        .setHeader(Exchange.HTTP_PATH, simple("/api/nmap/" + BASE_EXEC_STRING + "${headers.timing-template} ${headers.url}/${headers.netmask}"))
        .log("path: ${headers.CamelHttpPath}")
        .to("http4://localhost:1338?bridgeEndpoint=true&throwExceptionOnFailure=true")
        .unmarshal(jaxb)
        // explicitly set the output body so it can be serialized
        .process(e -> e.getOut().setBody(e.getIn().getBody(Nmaprun.class)));                         
  }
}
