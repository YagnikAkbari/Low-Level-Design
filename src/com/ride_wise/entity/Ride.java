package com.ride_wise.entity;

import com.ride_wise.enums.RideStatus;

public class Ride {
  private long id;
  private Driver driver;
  private Rider rider;
  private double distance;
  private RideStatus rideStatus;
}
