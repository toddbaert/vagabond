package org.outsrcd.vagabond.nmap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.exec.ExecBinding;
import org.springframework.stereotype.Component;

@Component
public class ExecNmapRoute extends RouteBuilder {
   
  @Override
  public void configure() throws Exception {       
      
      restConfiguration()
        .component("jetty")
        .port(1338)
        .contextPath("api");

      // Jetty interprets URLEncoded '/', so separate the rest of the command from /{netmask}
      rest("/nmap")
        .get("/{execString}/{netmask}")
          .produces("text/xml")
          .to("direct:nmap");
        
      from("direct:nmap")
        .log("${headers.execString}")
        // call nmap with with xml output
        .setHeader(ExecBinding.EXEC_COMMAND_ARGS, simple("${headers.execString}/${headers.netmask}"))
        .to("exec://nmap")
        .process(new Processor() {

          // remove stylesheet (for browser testing, otherwise will be cross domain request and fail)
          @Override
          public void process(Exchange exchange) throws Exception {
            String result = exchange.getIn().getBody(String.class);
            // regex to remove stylesheet href
            result = result.replaceAll("\\<\\?xml-stylesheet.*?>", "");
            exchange.getIn().setBody(result);
          }
        });                
  }
}
