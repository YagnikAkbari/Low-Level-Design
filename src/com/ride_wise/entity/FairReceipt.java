package com.ride_wise.entity;

import java.time.LocalDate;

public class FairReceipt {
  private long id;
  private long receiptId;
  private LocalDate generatedAt;
  private double amount;

  public FairReceipt(long id, long receiptId, LocalDate generatedAt, double amount) {
    this.id = id;
    this.receiptId = receiptId;
    this.generatedAt = generatedAt;
    this.amount = amount;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getReceiptId() {
    return receiptId;
  }

  public void setReceiptId(long receiptId) {
    this.receiptId = receiptId;
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
}
