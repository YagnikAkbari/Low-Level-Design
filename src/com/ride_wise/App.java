package com.ride_wise;

import com.ride_wise.repository.DriverRepository;
import com.ride_wise.repository.RideRepository;
import com.ride_wise.repository.RiderRepository;
import com.ride_wise.service.DriverService;
import com.ride_wise.service.RideService;
import com.ride_wise.service.RiderService;

public class App {

  public static void run() {
    DriverRepository driverRepository = new DriverRepository();
    DriverService driverService = new DriverService(driverRepository);
    RiderRepository riderRepository = new RiderRepository();
    RiderService riderService = new RiderService(riderRepository);
    RideRepository rideRepository = new RideRepository();
    RideService rideService = new RideService(rideRepository);
  }

  public static void main(String[] args) {
    System.out.println("Running main in src/com/ride_wise/App.java");
  }
}
