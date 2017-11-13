package org.outsrcd.vagabond.nmap;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.exec.ExecBinding;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class ExecNmapRoute extends RouteBuilder {
    
  @Override
  public void configure() throws Exception {       
      
      restConfiguration()
        .component("undertow")
        .port(1338)
        .contextPath("api");

      rest()
        .get("/nmap")
          .param().name("exec").type(RestParamType.query).endParam()
          .to("direct:nmap");
        
      from("direct:nmap")
        .log("exec: ${headers.exec}")
        // call nmap with with xml output
        .setHeader(ExecBinding.EXEC_COMMAND_ARGS, simple("${headers.exec}"))
        .to("exec://nmap")
        .convertBodyTo(String.class);               
  }
}
