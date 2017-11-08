package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Service {
  
  @XmlAttribute
  private String name;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private String conf;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getConf() {
    return conf;
  }

  public void setConf(String conf) {
    this.conf = conf;
  }

  @Override
  public String toString() {
    return "ClassPojo [name = " + name + ", method = " + method + ", conf = " + conf + "]";
  }
}