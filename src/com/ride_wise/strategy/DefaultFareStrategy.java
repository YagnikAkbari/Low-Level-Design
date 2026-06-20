package com.ride_wise.strategy;

import com.ride_wise.entity.Ride;

public class DefaultFareStrategy implements FareStrategy {
  private static final double BASE_FARE = 30.0;
  private static final double PER_KM_RATE = 12.0;

  @Override
  public double calculateFare(Ride ride) {
    if (ride == null) {
      return 0.0;
    }
    double distance = Math.max(0.0, ride.getDistance());
    return BASE_FARE + (distance * PER_KM_RATE);
  }
}
