package com.ride_wise.util;

public final class IDGenerator {
  private static long driverId = 0;
  private static long riderId = 0;
  private static long rideId = 0;
  private static long fairReceiptId = 0;

  private IDGenerator() {
  }

  public static long nextDriverId() {
    driverId = driverId + 1;
    return driverId;
  }

  public static long nextRiderId() {
    riderId = riderId + 1;
    return riderId;
  }

  public static long nextRideId() {
    rideId = rideId + 1;
    return rideId;
  }

  public static long nextFairReceiptId() {
    fairReceiptId = fairReceiptId + 1;
    return fairReceiptId;
  }
}
