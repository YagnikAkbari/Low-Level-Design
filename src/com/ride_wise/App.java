package com.ride_wise;

import com.ride_wise.entity.Driver;
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
    RideService rideService = new RideService(rideRepository);

    Driver[] demoDrivers = new Driver[] {
        new Driver(0, "", 29, "DL-12345-0001", "AADHAR-1001", "KA-01-HH-1234",
            "MG Road", true, VehicleType.CAR),
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
        // System.out.println("Failed to register driver " + ex.getErrors()
        // .map(Object::toString)
        // .orElse(ex.getMessage()));
        if (ex.getErrors().isPresent()) {
          System.out.println("Failed to register driver(Validation errors): " + ex.getErrors().get());
        } else {
          System.out.println("Failed to register driver(Invalid input): " + ex.getMessage());
        }
      }
    }

    System.out.println("All drivers after this operation:");
    for (Driver driver : driverService.getAllDrivers()) {
      System.out.println(driver);
    }
  }

  public static void main(String[] args) {
    run();
  }
}
