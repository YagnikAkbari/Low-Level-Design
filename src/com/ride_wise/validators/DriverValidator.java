package com.ride_wise.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ride_wise.entity.Driver;

public class DriverValidator {
  public static Optional<Map<String, String>> valid(Driver driver) {
    Map<String, String> errors = new HashMap<>();
    if (driver == null) {
      errors.put("driver", "driver must not be null");
      return Optional.of(errors);
    }
    if (driver.getName() == null || driver.getName().isBlank()) {
      errors.put("name", "name must not be empty");
    }
    if (driver.getAge() <= 0) {
      errors.put("age", "age must be greater than 0");
    }
    if (driver.getDlNumber() == null || driver.getDlNumber().isBlank()) {
      errors.put("dlNumber", "dl number must not be empty");
    }
    if (driver.getAadharNumber() == null || driver.getAadharNumber().isBlank()) {
      errors.put("aadharNumber", "aadhar number must not be empty");
    }
    if (driver.getVehicleNumber() == null || driver.getVehicleNumber().isBlank()) {
      errors.put("vehicleNumber", "vehicle number must not be empty");
    }
    if (driver.getCurrentLocation() == null || driver.getCurrentLocation().isBlank()) {
      errors.put("currentLocation", "current location must not be empty");
    }
    if (driver.getVehicleType() == null) {
      errors.put("vehicleType", "vehicle type must not be null");
    }
    if (!errors.isEmpty()) {
      return Optional.of(errors);
    }
    return Optional.empty();
  }
}
