package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Service {
  
  @XmlAttribute
  private String product;

  @XmlAttribute
  private String name;

  @XmlAttribute
  private String method;

  @XmlAttribute
  private String conf;

  @XmlAttribute
  private String cpe;

  @XmlAttribute
  private String extrainfo;

  @XmlAttribute
  private String version;

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

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

  public String getCpe() {
    return cpe;
  }

  public void setCpe(String cpe) {
    this.cpe = cpe;
  }

  public String getExtrainfo() {
    return extrainfo;
  }

  public void setExtrainfo(String extrainfo) {
    this.extrainfo = extrainfo;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return "ClassPojo [product = " + product + ", name = " + name + ", method = " + method + ", conf = " + conf
        + ", cpe = " + cpe + ", extrainfo = " + extrainfo + ", version = " + version + "]";
  }
}