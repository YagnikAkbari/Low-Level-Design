package com.ride_wise.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ride_wise.entity.Driver;

public class DriverValidator {
  public static Optional<Map<String, String>> valid(Driver driver) {
    Map<String, String> errors = new HashMap<>();
    if (driver.getName() == null || driver.getName().isBlank()) {
      errors.put("name", "name must not be empty");
    }
    if (!errors.isEmpty()) {
      return Optional.of(errors);
    }
    return Optional.empty();
  }
}
