package com.ride_wise.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ride_wise.entity.Rider;
import com.ride_wise.util.IDGenerator;

public class RiderRepository {
  private Map<Long, Rider> ridersMap = new HashMap<>();

  public Rider save(Rider rider) {
    long riderId = IDGenerator.nextRiderId();
    rider.setId(riderId);
    ridersMap.put(riderId, rider);
    return rider;
  }

  public List<Rider> findAll() {
    return ridersMap.values().stream().collect(Collectors.toList());
  }
}
