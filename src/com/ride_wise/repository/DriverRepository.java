package com.ride_wise.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.ride_wise.entity.Driver;
import com.ride_wise.exception.DuplicateAadharNumberFoundException;
import com.ride_wise.exception.DuplicateVehicleNumberFoundException;
import com.ride_wise.util.IDGenerator;

public class DriverRepository {

  private Map<Long, Driver> driversMap = new HashMap<>();
  private Set<String> aadharNumberIndex = new HashSet<>();
  private Set<String> vehicleNumberIndex = new HashSet<>();

  public Driver save(Driver driver) throws DuplicateAadharNumberFoundException, DuplicateVehicleNumberFoundException {
    if (!aadharNumberIndex.add(driver.getAadharNumber())) {
      throw new DuplicateAadharNumberFoundException(
          "aadhar number is already taken. plese try with another aadhar number.");
    }
    if (!vehicleNumberIndex.add(driver.getVehicleNumber())) {
      throw new DuplicateVehicleNumberFoundException(
          "vehicle number is already taken. plese try with another vehicle number.");
    }
    long driverId = IDGenerator.nextDriverId();
    driver.setId(driverId);
    driversMap.put(driverId, driver);
    aadharNumberIndex.add(driver.getAadharNumber());
    vehicleNumberIndex.add(driver.getVehicleNumber());
    return driver;
  }

  public List<Driver> findAll() {
    return driversMap.values().stream().collect(Collectors.toList());
  }

  public Optional<Driver> findById(long driverId) {
    return Optional.ofNullable(driversMap.get(driverId));
  }

  public List<Driver> findAllAvailable() {
    return driversMap.values().stream()
        .filter(Driver::isAvailable)
        .collect(Collectors.toList());
  }

}
