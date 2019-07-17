package com.liling.smartband.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_gps")
public class TGps {
  @Id
  private long id;
  private String remoteAddr;
  private String szManufacturer;
  private String deviceId;
  private String szCmd;
  private String dwUtcTime;
  private String cLatitude;
  private double fLatitudeValue;
  private String cLongitude;
  private double fcLongitudeValue;
  private String fSpeed;
  private String fDirection;
  private String dwDate;
  private String dwVehicleStatus;
  private String fAltitude;
  private long updateTime;
  private long active;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRemoteAddr() {
    return remoteAddr;
  }

  public void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }


  public String getSzManufacturer() {
    return szManufacturer;
  }

  public void setSzManufacturer(String szManufacturer) {
    this.szManufacturer = szManufacturer;
  }


  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }


  public String getSzCmd() {
    return szCmd;
  }

  public void setSzCmd(String szCmd) {
    this.szCmd = szCmd;
  }


  public String getDwUtcTime() {
    return dwUtcTime;
  }

  public void setDwUtcTime(String dwUtcTime) {
    this.dwUtcTime = dwUtcTime;
  }


  public String getCLatitude() {
    return cLatitude;
  }

  public void setCLatitude(String cLatitude) {
    this.cLatitude = cLatitude;
  }


  public double getFLatitudeValue() {
    return fLatitudeValue;
  }

  public void setFLatitudeValue(double fLatitudeValue) {
    this.fLatitudeValue = fLatitudeValue;
  }


  public String getCLongitude() {
    return cLongitude;
  }

  public void setCLongitude(String cLongitude) {
    this.cLongitude = cLongitude;
  }


  public double getFcLongitudeValue() {
    return fcLongitudeValue;
  }

  public void setFcLongitudeValue(double fcLongitudeValue) {
    this.fcLongitudeValue = fcLongitudeValue;
  }


  public String getFSpeed() {
    return fSpeed;
  }

  public void setFSpeed(String fSpeed) {
    this.fSpeed = fSpeed;
  }


  public String getFDirection() {
    return fDirection;
  }

  public void setFDirection(String fDirection) {
    this.fDirection = fDirection;
  }


  public String getDwDate() {
    return dwDate;
  }

  public void setDwDate(String dwDate) {
    this.dwDate = dwDate;
  }


  public String getDwVehicleStatus() {
    return dwVehicleStatus;
  }

  public void setDwVehicleStatus(String dwVehicleStatus) {
    this.dwVehicleStatus = dwVehicleStatus;
  }


  public String getFAltitude() {
    return fAltitude;
  }

  public void setFAltitude(String fAltitude) {
    this.fAltitude = fAltitude;
  }


  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }


  public long getActive() {
    return active;
  }

  public void setActive(long active) {
    this.active = active;
  }

}
