package com.ride_wise.entity;

import java.time.LocalDate;

public class FareReceipt {
  private long rideId;
  private LocalDate generatedAt;
  private double amount;

  public FareReceipt(long rideId, double amount, LocalDate generatedAt) {
    this.rideId = rideId;
    this.amount = amount;
    this.generatedAt = generatedAt;
  }

  public long getRideId() {
    return rideId;
  }

  public void setRideId(long rideId) {
    this.rideId = rideId;
  }

  public LocalDate getGeneratedAt() {
    return generatedAt;
  }

  public void setGeneratedAt(LocalDate generatedAt) {
    this.generatedAt = generatedAt;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "FareReceipt{"
        + "rideId=" + rideId
        + ", generatedAt=" + generatedAt
        + ", amount=" + amount
        + '}';
  }
}
