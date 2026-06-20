package com.ride_wise.service;

import com.ride_wise.repository.DriverRepository;

public class DriverService {
  private DriverRepository driverRepository;

  public DriverService(DriverRepository driverRepository) {
    this.driverRepository = driverRepository;
  }
}
