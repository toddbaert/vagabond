package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Runstats {

  private Finished finished;

  public Finished getFinished() {
    return finished;
  }

  public void setFinished(Finished finished) {
    this.finished = finished;
  }

  @Override
  public String toString() {
    return "ClassPojo [finished = " + finished + "]";
  }
}
