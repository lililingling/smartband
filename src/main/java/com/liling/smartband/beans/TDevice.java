package com.liling.smartband.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_device")
public class TDevice {
  @Id
  private long id;
  private String deviceId;
  private String simNo;
  private String registerTime;
  private long updateTime;
  private String online;
  private String states;
  private long active;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public String getSimNo() {
    return simNo;
  }

  public void setSimNo(String simNo) {
    this.simNo = simNo;
  }


  public String getRegisterTime() {
    return registerTime;
  }

  public void setRegisterTime(String registerTime) {
    this.registerTime = registerTime;
  }


  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }


  public String getOnline() {
    return online;
  }

  public void setOnline(String online) {
    this.online = online;
  }


  public String getStates() {
    return states;
  }

  public void setStates(String states) {
    this.states = states;
  }


  public long getActive() {
    return active;
  }

  public void setActive(long active) {
    this.active = active;
  }

}
