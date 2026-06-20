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
}
