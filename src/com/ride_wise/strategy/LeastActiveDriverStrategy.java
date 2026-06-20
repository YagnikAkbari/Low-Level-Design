package com.ride_wise.strategy;

import java.util.Comparator;
import java.util.List;

import com.ride_wise.entity.Driver;
import com.ride_wise.entity.Ride;
import com.ride_wise.entity.Rider;
import com.ride_wise.repository.RideRepository;

public class LeastActiveDriverStrategy implements RideMatchingStrategy {
  private final RideRepository rideRepository;

  public LeastActiveDriverStrategy(RideRepository rideRepository) {
    this.rideRepository = rideRepository;
  }

  @Override
  public Driver findDriver(Rider rider, List<Driver> drivers) {
    if (drivers == null || drivers.isEmpty()) {
      return null;
    }

    return drivers.stream()
        .filter(Driver::isAvailable)
        .min(Comparator
            .comparingLong(this::rideCountForDriver)
            .thenComparingLong(Driver::getId))
        .orElse(null);
  }

  private long rideCountForDriver(Driver driver) {
    if (rideRepository == null) {
      return 0L;
    }
    return rideRepository.findAll().stream()
        .map(Ride::getDriver)
        .filter(existingDriver -> existingDriver != null && existingDriver.getId() == driver.getId())
        .count();
  }
}
