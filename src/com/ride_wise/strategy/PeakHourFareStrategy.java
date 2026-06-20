package com.ride_wise.strategy;

import com.ride_wise.entity.Ride;

public class PeakHourFareStrategy implements FareStrategy {
  private static final double BASE_MULTIPLIER = 1.5;
  private final FareStrategy delegate;

  public PeakHourFareStrategy() {
    this(new DefaultFareStrategy());
  }

  public PeakHourFareStrategy(FareStrategy delegate) {
    this.delegate = delegate;
  }

  @Override
  public double calculateFare(Ride ride) {
    if (delegate == null) {
      return 0.0;
    }
    return delegate.calculateFare(ride) * BASE_MULTIPLIER;
  }
}
