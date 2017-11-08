package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Finished {
  
  @XmlAttribute
  private String elapsed;

  @XmlAttribute
  private String summary;

  @XmlAttribute
  private String time;

  @XmlAttribute
  private String timestr;

  @XmlAttribute
  private String exit;

  
  public String getElapsed() {
    return elapsed;
  }

  public void setElapsed(String elapsed) {
    this.elapsed = elapsed;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTimestr() {
    return timestr;
  }

  public void setTimestr(String timestr) {
    this.timestr = timestr;
  }

  public String getExit() {
    return exit;
  }

  public void setExit(String exit) {
    this.exit = exit;
  }

  @Override
  public String toString() {
    return "ClassPojo [elapsed = " + elapsed + ", summary = " + summary + ", time = " + time + ", timestr = " + timestr
        + ", exit = " + exit + "]";
  }
}