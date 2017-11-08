package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Times {
  
  @XmlAttribute
  private String to;

  @XmlAttribute
  private String rttvar;

  @XmlAttribute
  private String srtt;

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getRttvar() {
    return rttvar;
  }

  public void setRttvar(String rttvar) {
    this.rttvar = rttvar;
  }

  public String getSrtt() {
    return srtt;
  }

  public void setSrtt(String srtt) {
    this.srtt = srtt;
  }

  @Override
  public String toString() {
    return "ClassPojo [to = " + to + ", rttvar = " + rttvar + ", srtt = " + srtt + "]";
  }
}