package com.ride_wise.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import com.ride_wise.entity.Driver;
import com.ride_wise.entity.Rider;

public class NearestDriverStrategy implements RideMatchingStrategy {

  @Override
  public Driver findDriver(Rider rider, List<Driver> drivers) {
    if (rider == null || drivers == null || drivers.isEmpty()) {
      return null;
    }

    Comparator<Driver> comparator = Comparator
        .comparing((Driver driver) -> !Objects.equals(normalize(driver.getCurrentLocation()),
            normalize(rider.getLocation())))
        .thenComparingInt(driver -> -commonPrefixLength(normalize(driver.getCurrentLocation()),
            normalize(rider.getLocation())))
        .thenComparingLong(Driver::getId);

    return drivers.stream()
        .filter(Driver::isAvailable)
        .min(comparator)
        .orElse(null);
  }

  private String normalize(String value) {
    return value == null ? "" : value.trim().toLowerCase();
  }

  private int commonPrefixLength(String left, String right) {
    int limit = Math.min(left.length(), right.length());
    int count = 0;
    while (count < limit && left.charAt(count) == right.charAt(count)) {
      count++;
    }
    return count;
  }
}
