package com.ride_wise.entity;

import com.ride_wise.enums.VehicleType;

public class Driver {
  private long id;
  private String name;
  private int age;
  private String dlNumber;
  private String aadharNumber;
  private String vehicleNumber;
  private String currentLocation;
  private boolean available;
  private VehicleType vehicleType;

  public Driver(long id, String name, int age, String dlNumber, String aadharNumber, String vehicleNumber, String currentLocation, boolean available, VehicleType vehicleType) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.dlNumber = dlNumber;
    this.aadharNumber = aadharNumber;
    this.vehicleNumber = vehicleNumber;
    this.currentLocation = currentLocation;
    this.available = available;
    this.vehicleType = vehicleType;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDlNumber() {
    return dlNumber;
  }

  public void setDlNumber(String dlNumber) {
    this.dlNumber = dlNumber;
  }

  public String getAadharNumber() {
    return aadharNumber;
  }

  public void setAadharNumber(String aadharNumber) {
    this.aadharNumber = aadharNumber;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
  }
}