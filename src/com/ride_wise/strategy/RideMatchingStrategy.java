package com.ride_wise.strategy;

import java.util.List;

import com.ride_wise.entity.Driver;
import com.ride_wise.entity.Rider;

public interface RideMatchingStrategy {
  Driver findDriver(Rider rider, List<Driver> drivers);
}
