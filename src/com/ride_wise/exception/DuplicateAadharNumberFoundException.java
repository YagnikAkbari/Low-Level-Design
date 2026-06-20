package com.ride_wise.exception;

public class DuplicateAadharNumberFoundException extends ConstraintViolationException {
  public DuplicateAadharNumberFoundException(String message) {
    super(message);
  }
}
