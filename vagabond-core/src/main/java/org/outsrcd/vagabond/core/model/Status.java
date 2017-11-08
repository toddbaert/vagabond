package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Status {

  @XmlAttribute
  private String reason_ttl;

  @XmlAttribute
  private String reason;

  @XmlAttribute
  private String state;

  public String getReason_ttl() {
    return reason_ttl;
  }

  public void setReason_ttl(String reason_ttl) {
    this.reason_ttl = reason_ttl;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "ClassPojo [reason_ttl = " + reason_ttl + ", reason = " + reason + ", state = " + state + "]";
  }
}