package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Nmaprun {
  
  @XmlAttribute
  private String xmloutputversion;

  @XmlElement
  private Runstats runstats;

  @XmlAttribute
  private String start;

  @XmlElement
  private Scaninfo scaninfo;

  @XmlElement
  private Host host;
  
  @XmlAttribute
  private String args;

  @XmlElement
  private Verbose verbose;

  @XmlAttribute
  private String startstr;

  @XmlElement
  private Debugging debugging;

  @XmlAttribute
  private String scanner;

  @XmlAttribute
  private String version;

  public String getXmloutputversion() {
    return xmloutputversion;
  }

  public void setXmloutputversion(String xmloutputversion) {
    this.xmloutputversion = xmloutputversion;
  }

  public Runstats getRunstats() {
    return runstats;
  }

  public void setRunstats(Runstats runstats) {
    this.runstats = runstats;
  }

  public String getHost() {
    return start;
  }

  public void setHost(String start) {
    this.start = start;
  }
  
  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public Scaninfo getScaninfo() {
    return scaninfo;
  }

  public void setScaninfo(Scaninfo scaninfo) {
    this.scaninfo = scaninfo;
  }

  public String getArgs() {
    return args;
  }

  public void setArgs(String args) {
    this.args = args;
  }

  public Verbose getVerbose() {
    return verbose;
  }

  public void setVerbose(Verbose verbose) {
    this.verbose = verbose;
  }

  public String getStartstr() {
    return startstr;
  }

  public void setStartstr(String startstr) {
    this.startstr = startstr;
  }

  public Debugging getDebugging() {
    return debugging;
  }

  public void setDebugging(Debugging debugging) {
    this.debugging = debugging;
  }

  public String getScanner() {
    return scanner;
  }

  public void setScanner(String scanner) {
    this.scanner = scanner;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String toString() {
    return "ClassPojo [xmloutputversion = " + xmloutputversion + ", runstats = " + runstats + ", start = " + start
        + ", scaninfo = " + scaninfo + ", args = " + args + ", verbose = " + verbose + ", startstr = " + startstr
        + ", debugging = " + debugging + ", scanner = " + scanner + ", version = " + version + "]";
  }
}