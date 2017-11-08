package org.outsrcd.vagabond.core;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.outsrcd.vagabond.core.model.Nmaprun;
import org.springframework.stereotype.Component;

@Component
public class ScanRoute extends RouteBuilder {
  
  @Override
  public void configure() throws Exception {       
    
    
    
    JaxbDataFormat jaxb = new JaxbDataFormat("org.outsrcd.vagabond.core.model");
    
      restConfiguration()
        .component("jetty")
        .port(1337)
        .contextPath("api")
        .bindingMode(RestBindingMode.json_xml);        
      
      rest("/scan")
        .get("/{url}")
          .produces("application/json,application/xml")
          .type(Nmaprun.class)
          .to("direct:nmap-scan");

      from("direct:nmap-scan")
        .setHeader(Exchange.HTTP_PATH, simple("/api/nmap/${headers.url}"))
        .to("http4://localhost:1338?bridgeEndpoint=true&throwExceptionOnFailure=true")
        .unmarshal(jaxb)
        // explicitly set the output body so it can be serialized
        .process(e -> e.getOut().setBody(e.getIn().getBody(Nmaprun.class)));                         
  }
}
