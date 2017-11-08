package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Hostnames {
  
  private Hostname[] hostname;

  public Hostname[] getHostname() {
    return hostname;
  }

  public void setHostname(Hostname[] hostname) {
    this.hostname = hostname;
  }

  @Override
  public String toString() {
    return "ClassPojo [hostname = " + hostname + "]";
  }
}
