package org.outsrcd.vagabond.nmap;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.exec.ExecBinding;
import org.springframework.stereotype.Component;

@Component
public class NmapRestRoute extends RouteBuilder {
  
  @Override
  public void configure() throws Exception {       
      
      restConfiguration()
        .component("jetty")
        .port(1338)
        .contextPath("api");
      
      rest("/nmap").get("/{url}")
        .produces("text/xml")
        .to("direct:nmap");
        
      // call nmap with with xml output
      from("direct:nmap")
        .log("${headers.url}")
        .setHeader(ExecBinding.EXEC_COMMAND_ARGS, simple("--oX - ${headers.url}"))
        .to("exec://nmap")
        .process(new Processor() {

          // remove stylesheet (for browser testing, otherwise will be cross domain request and fail)
          @Override
          public void process(Exchange exchange) throws Exception {
            String result = exchange.getIn().getBody(String.class);
            //result = result.replace("<!DOCTYPE nmaprun>","");
            //result = result.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" );
            result = result.replace("<?xml-stylesheet href=\"file:///usr/bin/../share/nmap/nmap.xsl\" type=\"text/xsl\"?>", "");
            exchange.getIn().setBody(result);
          }
        });                
  }
}
