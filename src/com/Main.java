package com;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java com.Main <problem_name>");
      System.out.println("Available problems: result_management");
      return;
    }

    switch (args[0]) {
      case "result_management":
        com.result_management.App.run();
        break;
      case "library_management":
        com.library.App.run();
        break;
      case "learntrack":
        com.learntrack.App.run();
        break;
      case "food_delivery":
        com.food_delivery.App.run();
        break;
      case "ride_wise":
        com.ride_wise.App.run();
        break;
      default:
        System.out.println("Unknown problem: " + args[0]);
        System.out.println("Available problems: result_management, library_management, learntrack, ride_wise");
    }
  }
}
