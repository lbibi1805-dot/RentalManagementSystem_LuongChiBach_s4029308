package propertymanagement.manager;

import propertymanagement.entity.Host;
import propertymanagement.entity.Property;
import propertymanagement.entity.ResidentialProperty;
import propertymanagement.resources.Database;

import java.util.List;
import java.util.Scanner;

import static propertymanagement.resources.Database.IDGenerator;

public class ResidentialPropertyManager implements Manager {
    private Database db;
    List<Host> h;
    List<ResidentialProperty> rp;


    public ResidentialPropertyManager(Database db) {
        this.db = db;
        rp = db.getAll(ResidentialProperty.class);
        h = db.getAll(Host.class);
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

        System.out.print("Enter the number of bedrooms: ");
        int bedrooms = sc.nextInt();

        sc.nextLine();
        System.out.print("Does the property has a garden (enter y for yes or n for no): ");
        String garden = sc.nextLine();
        boolean hasGarden = false;
        if (garden.equalsIgnoreCase("y")) hasGarden = true;
        else if (garden.equalsIgnoreCase("n")) hasGarden = false;
        else System.out.println("Invalid Input.");

        System.out.print("Does the property allows pets (enter y for yes or n for no): ");
        String allowPets = sc.nextLine();
        boolean hasAllowPets = false;
        if (allowPets.equalsIgnoreCase("y")) hasAllowPets = true;
        else if (allowPets.equalsIgnoreCase("n")) hasAllowPets = false;
        else System.out.println("Invalid Input.");

        System.out.print("Enter the floor area of the residential property: ");
        double floorArea = sc.nextDouble();

        int ID = IDGenerator(ResidentialProperty.class);
        ResidentialProperty residentialProperty = new ResidentialProperty(ID, address, status, bedrooms, hasGarden, hasAllowPets, floorArea);
        if (db.add(residentialProperty)) System.out.println("Property added to database successfully.");
        else System.out.println("Cannot add residential property to the database.");
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the ID property:
        System.out.print("Enter the property's ID that you want to remove: ");
        int id = sc.nextInt();

        ResidentialProperty r = (ResidentialProperty) db.getByID(id);
        if (r != null) {
            if (db.remove(r)) System.out.println("Removed residential property successfully");
            else System.out.println("Cannot removed Residential Property");
        }
        else System.out.println("Cannot find the Residential Property");
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the id of the Residential Property you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

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

        System.out.println("Enter the number of bedrooms: ");
        int bedrooms = sc.nextInt();

        System.out.print("Does the property has a garden (enter y for yes or n for no): ");
        String garden = sc.nextLine();
        boolean hasGarden = false;
        if (garden.equalsIgnoreCase("y")) hasGarden = true;
        else if (garden.equalsIgnoreCase("n")) hasGarden = false;
        else System.out.println("Invalid Input.");

        System.out.print("Does the property allows pets (enter y for yes or n for no): ");
        String allowPets = sc.nextLine();
        boolean hasAllowPets = false;
        if (allowPets.equalsIgnoreCase("y")) hasAllowPets = true;
        else if (allowPets.equalsIgnoreCase("n")) hasAllowPets = false;
        else System.out.println("Invalid Input.");

        System.out.print("Enter the floor area of the residential property: ");
        double floorArea = sc.nextDouble();

        ResidentialProperty r = (ResidentialProperty) db.getByID(id);
        r.setAddress(address);
        r.setStatus(status);
        r.setBedrooms(bedrooms);
        r.setHasGarden(hasGarden);
        r.setAllowsPets(hasAllowPets);
        r.setArea(floorArea);
    }

    @Override
    public void displayAll() {
        for (ResidentialProperty r : rp) System.out.println(r);
    }
}
