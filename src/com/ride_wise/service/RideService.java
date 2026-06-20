package com.ride_wise.service;

import com.ride_wise.repository.RideRepository;

public class RideService {
  private RideRepository rideRepository;

  public RideService(RideRepository rideRepository) {
    this.rideRepository = rideRepository;
  }
}
