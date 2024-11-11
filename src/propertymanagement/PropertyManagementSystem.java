package propertymanagement;

import propertymanagement.manager.RentalManager;
import propertymanagement.manager.RentalManagerImplementation;

import java.util.Scanner;

public class PropertyManagementSystem {
    private RentalManager rentalManager;
    private Scanner scanner;

    public PropertyManagementSystem() {
        this.rentalManager = new RentalManagerImplementation();
        this.scanner = new Scanner(System.in);
    }

    private void displayMainMenu() {
        System.out.println("\n=== Rental Management System ===");
        System.out.println("1. Add");
        System.out.println("2. s");
        System.out.println("3. Manage Owners");
        System.out.println("4. Manage Properties");
        System.out.println("5. Manage Rental Agreements");
        System.out.println("6. Manage Payments");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
}
