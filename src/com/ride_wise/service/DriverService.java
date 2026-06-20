package com.ride_wise.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ride_wise.entity.Driver;
import com.ride_wise.exception.DuplicateAadharNumberFoundException;
import com.ride_wise.exception.DuplicateVehicleNumberFoundException;
import com.ride_wise.exception.InvalidInputException;
import com.ride_wise.repository.DriverRepository;
import com.ride_wise.validators.DriverValidator;

public class DriverService {
  private DriverRepository driverRepository;

  public DriverService(DriverRepository driverRepository) {
    this.driverRepository = driverRepository;
  }

  public Driver registerDriver(Driver driver)
      throws DuplicateAadharNumberFoundException, DuplicateVehicleNumberFoundException, InvalidInputException {
    Optional<Map<String, String>> errorsOptional = DriverValidator.valid(driver);
    if (!errorsOptional.isEmpty()) {
      throw new InvalidInputException("Please provide valid fields.", errorsOptional.get());
    }
    return driverRepository.save(driver);
  }

  public List<Driver> getAllDrivers() {
    return driverRepository.findAll();
  }

  public List<Driver> getAvailableDrivers() {
    return driverRepository.findAllAvailable();
  }

  public Optional<Driver> getDriverById(long driverId) {
    return driverRepository.findById(driverId);
  }

  public Driver updateAvailability(long driverId, boolean available)
      throws InvalidInputException {
    Optional<Driver> driverOptional = driverRepository.findById(driverId);
    if (driverOptional.isEmpty()) {
      throw new InvalidInputException("Driver not found for id: " + driverId);
    }
    Driver driver = driverOptional.get();
    driver.setAvailable(available);
    return driver;
  }
}
