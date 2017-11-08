package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Host {
  
  @XmlAttribute
  private String endtime;

  @XmlElement
  private Ports ports;

  @XmlAttribute
  private String starttime;

  @XmlElement
  private Status status;

  @XmlElement
  private Address address;

  @XmlElement
  private Times times;

  @XmlElement
  private Hostnames hostnames;

  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }

  public Ports getPorts() {
    return ports;
  }

  public void setPorts(Ports ports) {
    this.ports = ports;
  }

  public String getStarttime() {
    return starttime;
  }

  public void setStarttime(String starttime) {
    this.starttime = starttime;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Times getTimes() {
    return times;
  }

  public void setTimes(Times times) {
    this.times = times;
  }

  public Hostnames getHostnames() {
    return hostnames;
  }

  public void setHostnames(Hostnames hostnames) {
    this.hostnames = hostnames;
  }

  @Override
  public String toString() {
    return "ClassPojo [endtime = " + endtime + ", ports = " + ports + ", starttime = " + starttime + ", status = "
        + status + ", address = " + address + ", times = " + times + ", hostnames = " + hostnames + "]";
  }
}
