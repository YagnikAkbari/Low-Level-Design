package com.ride_wise.entity;

import com.ride_wise.enums.RideStatus;

public class Ride {
  private long id;
  private Driver driver;
  private Rider rider;
  private double distance;
  private RideStatus rideStatus;

  public Ride(long id, Driver driver, Rider rider, double distance, RideStatus rideStatus) {
    this.id = id;
    this.driver = driver;
    this.rider = rider;
    this.distance = distance;
    this.rideStatus = rideStatus;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

  public Rider getRider() {
    return rider;
  }

  public void setRider(Rider rider) {
    this.rider = rider;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public RideStatus getRideStatus() {
    return rideStatus;
  }

  public void setRideStatus(RideStatus rideStatus) {
    this.rideStatus = rideStatus;
  }

  @Override
  public String toString() {
    return "Ride{"
        + "id=" + id
        + ", driver=" + driver
        + ", rider=" + rider
        + ", distance=" + distance
        + ", rideStatus=" + rideStatus
        + '}';
  }
}
