package com.ride_wise.service;

import com.ride_wise.repository.RiderRepository;

public class RiderService {
  private RiderRepository riderRepository;

  public RiderService(RiderRepository riderRepository) {
    this.riderRepository = riderRepository;
  }
}
