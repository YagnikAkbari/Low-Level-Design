package com.ride_wise.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.ride_wise.entity.Driver;
import com.ride_wise.entity.FareReceipt;
import com.ride_wise.entity.Ride;
import com.ride_wise.entity.Rider;
import com.ride_wise.enums.RideStatus;
import com.ride_wise.exception.InvalidInputException;
import com.ride_wise.repository.DriverRepository;
import com.ride_wise.repository.RideRepository;
import com.ride_wise.strategy.DefaultFareStrategy;
import com.ride_wise.strategy.FareStrategy;
import com.ride_wise.strategy.NearestDriverStrategy;
import com.ride_wise.strategy.RideMatchingStrategy;

public class RideService {
  private final RideRepository rideRepository;
  private final DriverRepository driverRepository;
  private final RideMatchingStrategy rideMatchingStrategy;
  private final FareStrategy fareStrategy;

  public RideService(RideRepository rideRepository, DriverRepository driverRepository) {
    this(rideRepository, driverRepository, new NearestDriverStrategy(), new DefaultFareStrategy());
  }

  public RideService(RideRepository rideRepository, DriverRepository driverRepository,
      RideMatchingStrategy rideMatchingStrategy, FareStrategy fareStrategy) {
    this.rideRepository = rideRepository;
    this.driverRepository = driverRepository;
    this.rideMatchingStrategy = rideMatchingStrategy;
    this.fareStrategy = fareStrategy;
  }

  public Ride requestRide(Rider rider, double distance) throws InvalidInputException {
    validateRideRequest(rider, distance);

    List<Driver> availableDrivers = driverRepository.findAllAvailable();
    Driver assignedDriver = rideMatchingStrategy.findDriver(rider, availableDrivers);
    if (assignedDriver == null) {
      throw new InvalidInputException("No available driver found for rider: " + rider.getName());
    }

    Ride ride = new Ride(0, assignedDriver, rider, distance, RideStatus.REQUESTED);
    ride.setRideStatus(RideStatus.ASSIGNED);
    rideRepository.save(ride);

    assignedDriver.setAvailable(false);
    return ride;
  }

  public FareReceipt completeRide(long rideId) throws InvalidInputException {
    Ride ride = getRideByIdOrThrow(rideId);
    if (ride.getRideStatus() == RideStatus.COMPLETED) {
      throw new InvalidInputException("Ride is already completed.");
    }
    if (ride.getRideStatus() == RideStatus.CANCELLED) {
      throw new InvalidInputException("Cancelled ride cannot be completed.");
    }

    ride.setRideStatus(RideStatus.COMPLETED);
    rideRepository.save(ride);

    Driver driver = ride.getDriver();
    if (driver != null) {
      driver.setAvailable(true);
    }

    double amount = fareStrategy.calculateFare(ride);
    return new FareReceipt(ride.getId(), amount, LocalDate.now());
  }

  public Ride cancelRide(long rideId) throws InvalidInputException {
    Ride ride = getRideByIdOrThrow(rideId);
    if (ride.getRideStatus() == RideStatus.COMPLETED) {
      throw new InvalidInputException("Completed ride cannot be cancelled.");
    }

    ride.setRideStatus(RideStatus.CANCELLED);
    rideRepository.save(ride);

    Driver driver = ride.getDriver();
    if (driver != null) {
      driver.setAvailable(true);
    }
    return ride;
  }

  public List<Ride> getAllRides() {
    return rideRepository.findAll();
  }

  public Optional<Ride> getRideById(long rideId) {
    return rideRepository.findById(rideId);
  }

  private void validateRideRequest(Rider rider, double distance) throws InvalidInputException {
    if (rider == null) {
      throw new InvalidInputException("rider must not be null");
    }
    if (rider.getId() <= 0) {
      throw new InvalidInputException("rider must be registered before requesting a ride.");
    }
    if (distance <= 0) {
      throw new InvalidInputException("distance must be greater than 0");
    }
  }

  private Ride getRideByIdOrThrow(long rideId) throws InvalidInputException {
    Optional<Ride> rideOptional = rideRepository.findById(rideId);
    if (rideOptional.isEmpty()) {
      throw new InvalidInputException("Ride not found for id: " + rideId);
    }
    return rideOptional.get();
  }
}
