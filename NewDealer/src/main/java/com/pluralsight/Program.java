package com.pluralsight;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        System.out.println("===== Workshop Phases =====\n");

        System.out.println("Phase 1:");
        System.out.println("Create the VehicleDao and methods to allow a user to search the database for vehicles:");
        System.out.println("1. By price range");
        System.out.println("2. By make/model");
        System.out.println("3. By year range");
        System.out.println("4. By color");
        System.out.println("5. By mileage range");
        System.out.println("6. By type\n");

        System.out.println("Phase 2:");
        System.out.println("Add and remove vehicles from the database\n");

        System.out.println("Phase 3:");
        System.out.println("Create SalesDao and LeaseDao classes and update dealership logic to save sales/lease info\n");

        // Create DataSourceManager (your class to manage DB connections)
        DataSourceManager dataSourceManager = new DataSourceManager();

        // Create the DAO passing your DataSourceManager or DataSource
        VehicleDao vehicleDao = new VehicleDao(dataSourceManager);

        // Optional: test fetching vehicles by price range and print
        List<Vehicle> vehicles = vehicleDao.getVehiclesByPriceRange(10000, 30000);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
        }

        // Start the user interface menu for interactive commands
        UserInterface ui = new UserInterface(vehicleDao);
        ui.display();

        System.out.println("Program finished. Goodbye!");
    }
}
