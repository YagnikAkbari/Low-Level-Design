package com.ride_wise.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ride_wise.entity.Rider;

public class RiderValidator {
  public static Optional<Map<String, String>> valid(Rider rider) {
    Map<String, String> errors = new HashMap<>();
    if (rider == null) {
      errors.put("rider", "rider must not be null");
      return Optional.of(errors);
    }
    if (rider.getName() == null || rider.getName().isBlank()) {
      errors.put("name", "name must not be empty");
    }
    if (rider.getLocation() == null || rider.getLocation().isBlank()) {
      errors.put("location", "location must not be empty");
    }
    if (!errors.isEmpty()) {
      return Optional.of(errors);
    }
    return Optional.empty();
  }
}
