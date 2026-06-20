package com.ride_wise.exception;

public class ConstraintViolationException extends Exception {
  public ConstraintViolationException(String message) {
    super(message);
  }
}
