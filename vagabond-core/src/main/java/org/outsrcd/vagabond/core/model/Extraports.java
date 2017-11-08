package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Extraports {
  
  @XmlElement
  private Extrareasons extrareasons;

  @XmlAttribute
  private String count;

  @XmlAttribute
  private String state;

  public Extrareasons getExtrareasons() {
    return extrareasons;
  }

  public void setExtrareasons(Extrareasons extrareasons) {
    this.extrareasons = extrareasons;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "ClassPojo [extrareasons = " + extrareasons + ", count = " + count + ", state = " + state + "]";
  }
}