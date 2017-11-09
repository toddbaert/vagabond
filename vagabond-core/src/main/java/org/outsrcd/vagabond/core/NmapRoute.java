package org.outsrcd.vagabond.core;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
        .component("undertow")
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

      from("direct:nmap-scan")
        .noStreamCaching()
        .choice().when(simple("${headers.netmask} == null"))
          .setHeader(NETMASK_HEADER, constant("32"))
        .end() 
        .setHeader(Exchange.HTTP_PATH, simple("/api/nmap"))
        .setHeader(Exchange.REST_HTTP_QUERY, simple("exec=" + BASE_EXEC_STRING + "${headers.timing-template} ${headers.url}/${headers.netmask}"))
        .to("http4://localhost:1338?bridgeEndpoint=true&throwExceptionOnFailure=true")
        .unmarshal(jaxb);                      
  }
}
