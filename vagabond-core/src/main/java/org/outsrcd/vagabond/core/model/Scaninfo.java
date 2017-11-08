package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Scaninfo {

  @XmlAttribute
  private String protocol;

  @XmlAttribute
  private String services;

  @XmlAttribute
  private String numservices;

  @XmlAttribute
  private String type;

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getServices() {
    return services;
  }

  public void setServices(String services) {
    this.services = services;
  }

  public String getNumservices() {
    return numservices;
  }

  public void setNumservices(String numservices) {
    this.numservices = numservices;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ClassPojo [protocol = " + protocol + ", services = " + services + ", numservices = " + numservices
        + ", type = " + type + "]";
  }
}
