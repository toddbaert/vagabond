package org.outsrcd.vagabond.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.model.rest.RestParamType;
import org.outsrcd.vagabond.core.model.Nmaprun;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("serial")
public class NmapRoute extends RouteBuilder {
  
  private static final String BASE_EXEC_STRING = "--oX - --no-stylesheet";
  private static final String NETMASK_HEADER = "netmask";
  private static final String DETECT_ALL = "detect-all";
  private static final String DETECT_OS = "detect-os";
  private static final String LIST_SCAN = "list-scan";
  private static final String PING_SCAN = "ping-scan";
  private static final String PORT_RANGE = "port-range";
  private static final String TIMING_TEMPLATE = "timing-template";  
  
  private static final Map<String, String> argDictionary = new HashMap<String, String>(){{
    put(DETECT_ALL, "-A");
    put(DETECT_OS, "-O");
    put(LIST_SCAN, "-sL");
    put(PING_SCAN, "-sn");
    put(PORT_RANGE, "-p");
    put(TIMING_TEMPLATE, "-T");
  }};
  
  private static final List<RestOperationParamDefinition> paramDefinitions = new ArrayList<RestOperationParamDefinition>(){{
    add(new RestOperationParamDefinition().name(DETECT_ALL).type(RestParamType.query).dataType("boolean").defaultValue("false"));
    add(new RestOperationParamDefinition().name(DETECT_OS).type(RestParamType.query).dataType("boolean").defaultValue("false"));
    add(new RestOperationParamDefinition().name(LIST_SCAN).type(RestParamType.query).dataType("boolean").defaultValue("false"));
    add(new RestOperationParamDefinition().name(PING_SCAN).type(RestParamType.query).dataType("boolean").defaultValue("false"));
    add(new RestOperationParamDefinition().name(PORT_RANGE).type(RestParamType.query).dataType("string"));
    add(new RestOperationParamDefinition().name(TIMING_TEMPLATE).type(RestParamType.query).dataType("integer").defaultValue("3"));
  }};
    
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
          .params(paramDefinitions)
          .type(Nmaprun.class)
          .to("direct:nmap-scan")
        .get("/{url}/{netmask}")
          .params(paramDefinitions)
          .type(Nmaprun.class)
          .to("direct:nmap-scan");     

      from("direct:nmap-scan")
        .process(exchange -> {          
          String exec = BASE_EXEC_STRING;          
          Map<String, Object> headers = exchange.getIn().getHeaders();         
          for (Entry<String, String> entry : argDictionary.entrySet())
          {
            String queryParam = entry.getKey();   
            if (headers.get(queryParam) != null) {
              String queryParamValue = (String) headers.get(queryParam);
              if (Boolean.parseBoolean(queryParamValue)) {
                exec += " " + entry.getValue();   
              } else if (queryParamValue != "false") {
                exec += " " + entry.getValue() + queryParamValue;       
              }
            }
          }          
          exec += " " + headers.get("url");
          if (headers.get(NETMASK_HEADER) == null) {
            headers.put(NETMASK_HEADER, "32");
          }          
          headers.put("exec", exec + "/" + headers.get(NETMASK_HEADER));
        })
        .setHeader(Exchange.HTTP_PATH, simple("/api/nmap"))
        .log("path: ${headers.CamelRestHttpQuery}")
        .to("http4://localhost:1338?bridgeEndpoint=true&throwExceptionOnFailure=true")
        .unmarshal(jaxb);                      
  }
}
