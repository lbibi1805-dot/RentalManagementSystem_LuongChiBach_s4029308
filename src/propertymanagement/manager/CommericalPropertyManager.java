package propertymanagement.manager;

import propertymanagement.entity.CommercialProperty;
import propertymanagement.entity.Property;
import propertymanagement.resources.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static propertymanagement.resources.Database.IDGenerator;

public class CommericalPropertyManager implements Manager{
    private Database db;
    List<CommercialProperty> cp;

    public CommericalPropertyManager(Database db) {
        this.db = db;
        cp = db.getAll(CommercialProperty.class);
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the property's address: ");
        String address = sc.nextLine();

        System.out.println("Select the residential status: ");
        System.out.println("1. Enter 1 for AVAILABLE");
        System.out.println("2. Enter 2 for RENTED");
        System.out.println("3. Enter 3 for MAINTENANCE");
        int statusInput = sc.nextInt();
        Property.Status status;

        // Set the status based on user input
        if (statusInput == 1) {
            status = Property.Status.AVAILABLE;
        } else if (statusInput == 2) {
            status = Property.Status.RENTED;
        } else if (statusInput == 3) {
            status = Property.Status.MAINTENANCE;
        } else {
            System.out.println("Invalid status selected. Defaulting to AVAILABLE.");
            status = Property.Status.AVAILABLE; // Default case
        }

        System.out.print("Enter the business type of the property: ");
        String businessType = sc.nextLine();
        sc.nextLine();

        System.out.print("Does the property has parking spaces (y for yes, n for no): ");
        String parkingSpace = sc.nextLine();
        boolean hasParkingSpace = false;
        if (parkingSpace.equalsIgnoreCase("y")) hasParkingSpace = true;
        else if (parkingSpace.equalsIgnoreCase("n")) hasParkingSpace = false;
        else System.out.println("Invalid Input.");

        System.out.print("Enter the floor area of the residential property: ");
        double floorArea = sc.nextDouble();

        int id = IDGenerator(CommercialProperty.class);
        CommercialProperty commercialProperty = new CommercialProperty(id, address, status, businessType, hasParkingSpace, floorArea);

        if (db.add(commercialProperty)) {
            System.out.println("Property added to database successfully.");
//            System.out.println(commercialProperty);
        }
        else System.out.println("Cannot add Commercial Property to database.");
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the ID property:
        System.out.println("Enter the property's id you want to remove: ");
        int id = sc.nextInt();

        CommercialProperty c = (CommercialProperty) db.getByID(id);
        if (c != null) {
            if (db.remove(c)) System.out.println("Property deleted successfully from database.");
            else System.out.println("Property deleted from database failed.");
        }
        else System.out.println("Cannot fine the Commercial Property.");

    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the property's id you want to update: ");
        int id = sc.nextInt();

        System.out.print("Enter the property's address: ");
        String address = sc.nextLine();

        System.out.println("Select the residential status: ");
        System.out.println("1. Enter 1 for AVAILABLE");
        System.out.println("2. Enter 2 for RENTED");
        System.out.println("3. Enter 3 for MAINTENANCE");
        int statusInput = sc.nextInt();
        Property.Status status;

        // Set the status based on user input
        if (statusInput == 1) {
            status = Property.Status.AVAILABLE;
        } else if (statusInput == 2) {
            status = Property.Status.RENTED;
        } else if (statusInput == 3) {
            status = Property.Status.MAINTENANCE;
        } else {
            System.out.println("Invalid status selected. Defaulting to AVAILABLE.");
            status = Property.Status.AVAILABLE; // Default case
        }
        sc.nextLine();

        System.out.print("Enter the business type of the property: ");
        String businessType = sc.nextLine();

        System.out.print("Does the property has parking spaces: ");
        String parkingSpace = sc.nextLine();
        boolean hasParkingSpace = false;
        if (parkingSpace.equalsIgnoreCase("y")) hasParkingSpace = true;
        else if (parkingSpace.equalsIgnoreCase("n")) hasParkingSpace = false;
        else System.out.println("Invalid Input.");

        System.out.print("Enter the floor area of the residential property: ");
        double floorArea = sc.nextDouble();

        CommercialProperty c = (CommercialProperty) db.getByID(id);
        if (c != null) {
            c.setAddress(address);
            c.setStatus(status);
            c.setBusinessType(businessType);
            c.setStatus(status);
            c.setFloorArea(floorArea);
        } else System.out.println("Cannot find the Commercial Property.");
    }

    @Override
    public void displayAll() {
        for (CommercialProperty c : cp) {
            System.out.println(c);
        }
    }
}
