package com.ride_wise.strategy;

import com.ride_wise.entity.Ride;

public interface FareStrategy {
  double calculateFare(Ride ride);
}
