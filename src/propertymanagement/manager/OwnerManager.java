package propertymanagement.manager;

import propertymanagement.entity.CommercialProperty;
import propertymanagement.entity.Owner;
import propertymanagement.entity.Property;
import propertymanagement.entity.ResidentialProperty;
import propertymanagement.resources.Database;

import java.util.List;
import java.util.Scanner;

import static propertymanagement.resources.Database.IDGenerator;
import static propertymanagement.util.UIHelper.parseDate;

public class OwnerManager implements Manager{
    private Database db;
    List<Owner> owner;
    List<CommercialProperty> cp;
    List<ResidentialProperty> rp;


    public OwnerManager(Database db) {
        this.db = db;
        owner = db.getAll(Owner.class);
        cp = db.getAll(CommercialProperty.class);
        rp = db.getAll(ResidentialProperty.class);
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the Information of the owner:
        System.out.print("Enter owner's full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter owner Date of Birth (format: DD/MM/YYYY): ");
        String dateOfBirth = sc.nextLine();

        System.out.print("Enter owner's email: ");
        String email = sc.nextLine();

        System.out.print("Enter owner's phone number: ");
        String phoneNumber = sc.nextLine();

        int ID = IDGenerator(Owner.class);
        Owner o = new Owner(ID, fullName, parseDate(dateOfBirth), email, phoneNumber);
        if(owner.add(o)) System.out.println("Added Owner to database Successfully");
        else System.out.println("Failed to add Owner to Database");
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to input the ID of the owner:
        System.out.print("Enter owner's id: ");
        int id = sc.nextInt();

        Owner o = (Owner) db.getByID(id);
        if (o != null){
            if (db.remove(o)) System.out.println("Removed owner successfully");
            else System.out.println("Cannot removed owner");
        } else System.out.println("Cannot find the owner.");
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the Information of the owner:
        System.out.print("Enter the id of the owner you want to update the information: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter owner's full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter owner Date of Birth (format: DD/MM/YYYY): ");
        String dateOfBirth = sc.nextLine();

        System.out.print("Enter owner's email: ");
        String email = sc.nextLine();

        System.out.print("Enter owner's phone number: ");
        String phoneNumber = sc.nextLine();

        Owner o = (Owner) db.getByID(id);
        if (o != null){
            o.setFullName(fullName);
            o.setDateOfBirth(parseDate(dateOfBirth));
            o.setEmail(email);
            o.setPhoneNumber(phoneNumber);
        } else System.out.println("Cannot find the owner");
    }

    @Override
    public void displayAll() {
        for (Owner o : owner) System.out.println(o);
    }

    public void addProperty() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do{
            System.out.println("_________ Add Property to Owner__________");
            System.out.println("1. Add Commercial Property.");
            System.out.println("2. Add Residential Property.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1){
                // Initializes Variable
                boolean checkOwnerAvailable = false;
                boolean isPropertyAvailable = false;
                int idOwner, idProperty;
                Owner o = null;
                CommercialProperty c = null;

                // Get Owner ID:
                do {
                    System.out.print("Enter the ID of the owner: ");
                    idOwner = sc.nextInt();

                    o = (Owner) db.getByID(idOwner);

                    if (o != null) checkOwnerAvailable = true;
                    else System.out.println("Owner does not exists");

                } while (!checkOwnerAvailable);

                // Get Property ID:
                do{
                    System.out.print("Enter the ID of the property: ");
                    idProperty = sc.nextInt();

                    c = (CommercialProperty) db.getByID(idProperty);

                    if (c != null) {
                        if (c.getOwner() == null) isPropertyAvailable = true;
                        else System.out.println("Property already has an owner.");
                    } else System.out.println("Property does not exist.");

                } while (!isPropertyAvailable);

                o.addOwnedProperty(c);         // Add Property to Owner
                c.setOwner(o);                 // Add Owner to Property

                System.out.println("Property added successfully");
                System.out.println(o.getOwnedProperties());
                System.out.println(c.getOwner());
            }
            else if (choice == 2){
                boolean checkOwnerAvailable = false, isPropertyAvailable = false;
                int idOwner, idProperty;
                ResidentialProperty r = null;
                Owner o = null;

                // Get Owner ID:
                do{
                    System.out.print("Enter the ID of the owner: ");
                    idOwner = sc.nextInt();

                    o = (Owner) db.getByID(idOwner);

                    if (o != null) checkOwnerAvailable = true;
                    else System.out.println("Owner does not exists");
                } while (!checkOwnerAvailable);

                // Get Property ID:
                do{
                    System.out.print("Enter the ID of the property: ");
                    idProperty = sc.nextInt();

                    r = (ResidentialProperty) db.getByID(idProperty);

                    if (r != null){
                        if (r.getOwner() == null) isPropertyAvailable = true;
                        else System.out.println("Property already has an owner.");
                    }
                    else System.out.println("Property already has an owner.");
                } while (!isPropertyAvailable);

                o.addOwnedProperty(r);  // Add Property to Owner
                r.setOwner(o);          // Add Owner to Property

                System.out.println("Property added successfully");
                System.out.println(o.getOwnedProperties());
                System.out.println(r.getOwner());
            }
        } while (choice != 0);
    }

    public void removeProperty(){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do{
            System.out.println("------Remove Property From Owner_________");
            System.out.println("1. Remove Commercial Property.");
            System.out.println("2. Remove Residential Property.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Commercial Property
            if (choice == 1){
                int onwerID, propertyID;
                boolean findOwner = false, findProperty = false;
                Owner o = null;
                CommercialProperty c = null;

                // Get the Owner
                do{
                    System.out.print("Enter the ID of the owner: ");
                    onwerID = sc.nextInt();

                    o = (Owner) db.getByID(onwerID);

                    if (o != null) findOwner = true;
                    else System.out.println("Cannot find owner");
                } while (!findOwner);

                // print out the list of the property owned by the owner
                System.out.println(o.getOwnedProperties());

                // Get the property's information
                do {
                    System.out.print("Enter the ID of the property: ");
                    propertyID = sc.nextInt();

                    c = (CommercialProperty) db.getByID(propertyID);

                    // CHeck if the property exists in the database
                    if (c != null) findProperty = true;
                    else System.out.println("Cannot find property in database.");

                    // Check if the property is owned by the owner
                    if (o.getOwnedProperties().contains(c)) continue;
                    else {
                        System.out.println("Property does not owned by this owner.");
                        findProperty = false;
                    }
                } while (!findProperty);

                o.removeOwnedProperty(c);               // Removed the Property from the Owner
                c.setOwner(null);                       // Set the Property's owner to NULL

                System.out.println("Property removed successfully");
                System.out.println(o.getOwnedProperties());
                System.out.println(c.getOwner());
            }

            // Residential Property
            else if (choice == 2){
                int ownerID, propertyID;
                boolean findOwner = false, findProperty = false;
                ResidentialProperty r = null;
                Owner o = null;

                // Get the owner:
                do {
                    System.out.print("Enter the ID of the owner: ");
                    ownerID = sc.nextInt();

                    o = (Owner) db.getByID(ownerID);

                    if (o != null) findOwner = true;
                    else System.out.println("Cannot find owner");
                } while (!findOwner);

                // Print out the list of properties owned by the owner
                System.out.println(o.getOwnedProperties());

                // Get the Property
                do {
                    System.out.print("Enter the ID of the property: ");
                    propertyID = sc.nextInt();

                    r = (ResidentialProperty) db.getByID(propertyID);

                    // Check if the Property exists in the database:
                    if (r != null) findProperty = true;
                    else System.out.println("Cannot find property in database.");

                    // Check if the Property is owned by the Owner:
                    if (o.getOwnedProperties().contains(r)) continue;
                    else {
                        System.out.println("Property does not owned by this owner.");
                        findProperty = false;
                    }
                } while (!findProperty);

                o.removeOwnedProperty(r);           // Removed the Property from the Owner
                r.setOwner(null);                   // Set the Property's owner to NULL

                System.out.println("Property removed successfully");
                System.out.println(o.getOwnedProperties());
                System.out.println(r.getOwner());
            }

        } while (choice != 0);

    }
}

