package com.ride_wise.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ride_wise.entity.Ride;
import com.ride_wise.util.IDGenerator;

public class RideRepository {
  private Map<Long, Ride> ridesMap = new HashMap<>();

  public Ride save(Ride ride) {
    if (ride.getId() <= 0) {
      ride.setId(IDGenerator.nextRideId());
    }
    ridesMap.put(ride.getId(), ride);
    return ride;
  }

  public Optional<Ride> findById(long rideId) {
    return Optional.ofNullable(ridesMap.get(rideId));
  }

  public List<Ride> findAll() {
    return ridesMap.values().stream().collect(Collectors.toList());
  }
}
