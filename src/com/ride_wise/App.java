package com.ride_wise;

import com.ride_wise.entity.Driver;
import com.ride_wise.entity.Ride;
import com.ride_wise.entity.Rider;
import com.ride_wise.enums.VehicleType;
import com.ride_wise.exception.DuplicateAadharNumberFoundException;
import com.ride_wise.exception.DuplicateVehicleNumberFoundException;
import com.ride_wise.exception.InvalidInputException;
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
    RideService rideService = new RideService(rideRepository, driverRepository);

    Driver[] demoDrivers = new Driver[] {
        new Driver(0, "", -29, "DL-12345-0001", "AADHAR-1001", "KA-01-HH-1234",
            null, true, null),
        new Driver(0, "Neha Verma", 34, "DL-12345-0002", "AADHAR-1002", "KA-01-HH-2234",
            "Indiranagar", true, VehicleType.AUTO),
        new Driver(0, null, 31, "DL-12345-0003", "AADHAR-1001", "KA-01-HH-3234",
            "Koramangala", true, VehicleType.BIKE),
        new Driver(0, "Priya Iyer", 27, "DL-12345-0004", "AADHAR-1004", "KA-01-HH-2234",
            "Whitefield", true, VehicleType.CAR)
    };

    for (Driver driver : demoDrivers) {
      try {
        Driver savedDriver = driverService.registerDriver(driver);
        System.out.println("Registered driver: " + savedDriver);
      } catch (DuplicateAadharNumberFoundException | DuplicateVehicleNumberFoundException ex) {
        System.out.println("Failed to register driver '" + driver.getName() + "': " + ex.getMessage());
      } catch (InvalidInputException ex) {
        if (ex.getErrors().isPresent()) {
          System.out.println("Failed to register driver(Validation errors): " + ex.getErrors().get());
        } else {
          System.out.println("Failed to register driver(Invalid input): " + ex.getMessage());
        }
      }
    }

    Rider[] demoRiders = new Rider[] {
        new Rider(0, "", "Koramangala"),
        new Rider(0, "Anita Rao", "Indiranagar"),
        new Rider(0, null, "Whitefield"),
        new Rider(0, "Karthik Menon", "")
    };

    for (Rider rider : demoRiders) {
      try {
        Rider savedRider = riderService.registerRider(rider);
        System.out.println("Registered rider: " + savedRider);
      } catch (InvalidInputException ex) {
        if (ex.getErrors().isPresent()) {
          System.out.println("Failed to register rider(Validation errors): " + ex.getErrors().get());
        } else {
          System.out.println("Failed to register rider(Invalid input): " + ex.getMessage());
        }
      }
    }

    System.out.println("Available drivers:");
    for (Driver driver : driverService.getAvailableDrivers()) {
      System.out.println(driver);
    }

    System.out.println("All riders:");
    for (Rider rider : riderService.getAllRiders()) {
      System.out.println(rider);
    }

    try {
      Rider rider = riderService.getRiderById(1L).orElse(null);
      if (rider != null) {
        System.out.println("Requesting ride for rider: " + rider.getName());
        Ride ride = rideService.requestRide(rider, 8.5);
        System.out.println("Ride created: " + ride);
        System.out.println("Ride receipt: " + rideService.completeRide(ride.getId()));
      }
    } catch (InvalidInputException ex) {
      System.out.println("Ride operation failed: " + ex.getMessage());
    }

    System.out.println("All rides:");
    for (Ride ride : rideService.getAllRides()) {
      System.out.println(ride);
    }
  }

  public static void main(String[] args) {
    run();
  }
}
