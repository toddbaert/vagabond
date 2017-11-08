package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Port {
  
  @XmlAttribute
  private String protocol;

  @XmlAttribute
  private String portid;

  @XmlElement
  private State state;

  @XmlElement
  private Service service;

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public String getPortid() {
    return portid;
  }

  public void setPortid(String portid) {
    this.portid = portid;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  @Override
  public String toString() {
    return "ClassPojo [protocol = " + protocol + ", portid = " + portid + ", state = " + state + ", service = "
        + service + "]";
  }
}