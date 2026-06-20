# Ride Booking System (LLD)

## Brief

### Learning Objectives

### OOP & SOLID

**SRP:** Single-purpose classes (RideService, DriverService, FareCalculator)

**OCP:** Adding new ride selection or pricing strategies without modifying core logic

**LSP:** Any strategy implementation must remain interchangeable

**ISP:** Small focused interfaces (RideMatchingStrategy, FareStrategy)

**DIP:** Services depend on interfaces — not concrete classes

### Design Principles

**DRY:** eliminate duplication in ride allocation logic

**KISS:** simple entity modeling

**YAGNI:** MVP before features explosion

**Law of Demeter:** Services communicate with collaborators directly — no deep method chains

### LLD Skills

* Modeling entities & relationships
* Separating concerns into layers
* Designing scalable extension points

---

# Project Requirements

## A. Functional Requirements

* Register Riders
* Register Drivers
* Show available drivers
* Request a ride
* Match ride to driver using a strategy
* Calculate fare using a pricing strategy

### Track ride status:

* REQUESTED
* ASSIGNED
* COMPLETED
* CANCELLED

---

## B. Non-Functional Requirements

* Easily extendable pricing algorithm
* Easily change driver matching logic
* Low coupling between services
* Maintainable and readable code

---

## C. Domain Entities

### Package → `model/`

### Core Classes

#### Rider

* id
* name
* location

#### Driver

* id
* name
* currentLocation
* available (boolean)

#### Ride

* id
* rider
* driver
* distance
* status

#### FareReceipt

* rideId
* amount
* generatedAt

### Enums

#### RideStatus

#### VehicleType

* BIKE
* AUTO
* CAR

---

## D. Strategy & Composition Design

### 1. Ride Matching Strategy

```java
public interface RideMatchingStrategy {

    Driver findDriver(Rider rider, List<Driver> drivers);

}
```

### Implementations

* NearestDriverStrategy
* LeastActiveDriverStrategy

### 2. Fare Calculation Strategy

```java
public interface FareStrategy {

    double calculateFare(Ride ride);

}
```

### Implementations

* DefaultFareStrategy
* PeakHourFareStrategy

These strategies are injected into the RideService constructor.

### This ensures

* DIP compliance
* OCP compliance
* Composition over inheritance

---

## E. Service Layer

### Package → `service/`

### RiderService

* Register riders
* Get rider by ID

### DriverService

* Register drivers
* Update availability
* List available drivers

### RideService

* Request a ride
* Assign driver using RideMatchingStrategy
* Calculate fare using FareStrategy
* Complete ride

---

## F. Console Application (Menu)

Main menu in `Main.java`:

1. Add Rider
2. Add Driver
3. View Available Drivers
4. Request Ride
5. Complete Ride
6. View Rides
7. Exit

### Each option must

* Use service-layer only
* Catch invalid input
* Avoid tightly-coupled logic

---

# Suggested Package Structure

```text
src/
│
├── model/
│   ├── Rider.java
│   ├── Driver.java
│   ├── Ride.java
│   ├── FareReceipt.java
│   ├── RideStatus.java
│   └── VehicleType.java
│
├── strategy/
│   ├── RideMatchingStrategy.java
│   ├── NearestDriverStrategy.java
│   ├── LeastActiveDriverStrategy.java
│   ├── FareStrategy.java
│   ├── DefaultFareStrategy.java
│   └── PeakHourFareStrategy.java
│
├── service/
│   ├── RiderService.java
│   ├── DriverService.java
│   └── RideService.java
│
└── Main.java
```

---

# Architecture Goals

* Follow SOLID principles
* Use Strategy Pattern for extensibility
* Keep business logic inside services
* Prefer composition over inheritance
* Maintain low coupling and high cohesion
* Enable easy future enhancements without modifying existing code

---

# Future Extensions

* Multiple vehicle categories
* Driver ratings
* Ride cancellation charges
* Surge pricing
* Coupon support
* Payment integration
* Trip history
* Driver earnings dashboard
* Ride scheduling
* Location tracking

---

# Author

Low Level Design (LLD) Ride Booking System demonstrating SOLID principles, Strategy Pattern, clean architecture, and extensible service-layer design.
