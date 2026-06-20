package com.ride_wise.exception;

import java.util.Map;
import java.util.Optional;

public class InvalidInputException extends Exception {
  private Optional<Map<String, String>> errors;

  public InvalidInputException(String message) {
    super(message);
    this.errors = Optional.empty();
  }

  public InvalidInputException(String message, Map<String, String> errors) {
    super(message);
    this.errors = Optional.of(errors);
  }

  public Optional<Map<String, String>> getErrors() {
    return errors;
  }
}
