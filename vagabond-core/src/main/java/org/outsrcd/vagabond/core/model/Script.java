package org.outsrcd.vagabond.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Script {

  @XmlAttribute
  private String id;

  @XmlElement
  private Table[] table;

  @XmlAttribute
  private String output;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Table[] getTable() {
    return table;
  }

  public void setTable(Table[] table) {
    this.table = table;
  }

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  @Override
  public String toString() {
    return "ClassPojo [id = " + id + ", table = " + table + ", output = " + output + "]";
  }
}