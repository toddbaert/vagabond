package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Address {
  
  @XmlAttribute
  private String addrtype;

  @XmlAttribute
  private String addr;

  public String getAddrtype() {
    return addrtype;
  }

  public void setAddrtype(String addrtype) {
    this.addrtype = addrtype;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  @Override
  public String toString() {
    return "ClassPojo [addrtype = " + addrtype + ", addr = " + addr + "]";
  }
}