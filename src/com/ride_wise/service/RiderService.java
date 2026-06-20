package com.ride_wise.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ride_wise.entity.Rider;
import com.ride_wise.exception.InvalidInputException;
import com.ride_wise.repository.RiderRepository;
import com.ride_wise.validators.RiderValidator;

public class RiderService {
  private RiderRepository riderRepository;

  public RiderService(RiderRepository riderRepository) {
    this.riderRepository = riderRepository;
  }

  public Rider registerRider(Rider rider) throws InvalidInputException {
    Optional<Map<String, String>> errorsOptional = RiderValidator.valid(rider);
    if (!errorsOptional.isEmpty()) {
      throw new InvalidInputException("Please provide valid fields.", errorsOptional.get());
    }
    return riderRepository.save(rider);
  }

  public List<Rider> getAllRiders() {
    return riderRepository.findAll();
  }
}
