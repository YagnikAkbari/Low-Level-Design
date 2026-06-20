package com.ride_wise.exception;

public class DuplicateVehicleNumberFoundException extends ConstraintViolationException {
  public DuplicateVehicleNumberFoundException(String message) {
    super(message);
  }
}
