package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Table {
  
  private Elem[] elem;

  public Elem[] getElem() {
    return elem;
  }

  public void setElem(Elem[] elem) {
    this.elem = elem;
  }

  @Override
  public String toString() {
    return "ClassPojo [elem = " + elem + "]";
  }
}
