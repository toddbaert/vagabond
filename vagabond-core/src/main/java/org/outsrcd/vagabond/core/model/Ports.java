package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Ports {
  
  private Extraports extraports;

  private Port[] port;

  public Extraports getExtraports() {
    return extraports;
  }

  public void setExtraports(Extraports extraports) {
    this.extraports = extraports;
  }

  public Port[] getPort() {
    return port;
  }

  public void setPort(Port[] port) {
    this.port = port;
  }

  @Override
  public String toString() {
    return "ClassPojo [extraports = " + extraports + ", port = " + port + "]";
  }
}