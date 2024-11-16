package propertymanagement.manager;

import propertymanagement.entity.CommercialProperty;
import propertymanagement.entity.Host;
import propertymanagement.entity.Owner;
import propertymanagement.entity.ResidentialProperty;
import propertymanagement.resources.Database;

import java.util.List;
import java.util.Scanner;

import static propertymanagement.resources.Database.IDGenerator;
import static propertymanagement.util.UIHelper.parseDate;

public class HostManager implements Manager{
    private Database db;
    List<CommercialProperty> cp;
    List<ResidentialProperty> rp;
    List<Host> h;
    List<Owner> owners;

    public HostManager(Database db) {
        this.db = db;
        this.h = db.getAll(Host.class);
        this.cp = db.getAll(CommercialProperty.class);
        this.rp = db.getAll(ResidentialProperty.class);
        this.owners = db.getAll(Owner.class);
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter host's full name: ");
        String name = sc.nextLine();

        System.out.print("Enter host's date of birth(DD/MM/YYYY): ");
        String dateOfBirth = sc.nextLine();

        System.out.print("Enter host's EMAIL address: ");
        String email = sc.nextLine();

        System.out.print("Enter host's phone number: ");
        String phone = sc.nextLine();

        int id = IDGenerator(Host.class);

        Host host = new Host(id, name, parseDate(dateOfBirth), email, phone);

        if (db.add(host)) {
            System.out.println("Host added successfully" );
        } else System.out.println("Cannot add host to database");
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the Host ID:
        System.out.println("Enter the id of the host you want to remove: ");
        int id = sc.nextInt();

        Host o = (Host) db.getByID(id);

        if (o != null) {
            // Remove from database
            if (h.remove(o)) System.out.println("Host removed successfully from database");
            else System.out.println("Cannot remove host from database");
        }
        else System.out.println("Cannot find the host");
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the id of the host you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter host's full name: ");
        String name = sc.nextLine();

        System.out.print("Enter host's date of birth(DD/MM/YYYY): ");
        String dateOfBirth = sc.nextLine();

        System.out.print("Enter host's EMAIL address: ");
        String email = sc.nextLine();

        System.out.print("Enter host's phone number: ");
        String phone = sc.nextLine();


        Host o = (Host) db.getByID(id);
        o.setFullName(name);
        o.setDateOfBirth(parseDate(dateOfBirth));
        o.setEmail(email);
        o.setPhoneNumber(phone);
    }

    @Override
    public void displayAll() {
        for (Host h : h) {
            System.out.println(h);
        }
    }

    // Other Features:
    public void addManagedProperties() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do{
            System.out.println("__________Add Managed Property To Manager_____________");
            System.out.println("1. Add Commercial Property");
            System.out.println("2. Add Residential Property");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                int idHost, idProperty;
                Host host = null;
                CommercialProperty commercialProperty = null;
                boolean checkHOst = false, checkProperty = false;

                // Get the Host:
                do{
                    System.out.print("Enter the id of the Host: ");
                    idHost = sc.nextInt();

                    host = (Host) db.getByID(idHost);

                    if (host != null) checkHOst = true;
                    else System.out.println("Host does not exists.");
                } while (!checkHOst);

                // Display the Properties managed by this host:
                System.out.println("Commercial Property managed by this owner: ");
                System.out.println(host.getManagedProperties());
                System.out.println();

                // Get the Property:
                do {
                    System.out.print("Enter the ID of the Property: ");
                    idProperty = sc.nextInt();

                    commercialProperty = (CommercialProperty) db.getByID(idProperty);

                    if (commercialProperty != null) {
                        if(!host.getManagedProperties().contains(commercialProperty)) checkProperty = true;
                        else System.out.println("Property already managed by this host.");
                    }
                    else System.out.println("Property does not exist in database.");
                } while (!checkProperty);

                host.addManagedProperty(commercialProperty);                // Add Property to Host
                if(!host.getAssociatedOwners().contains(commercialProperty.getOwner())){
                    host.addAssociatedOwner(commercialProperty.getOwner());     // Add associated Owner
                }
                commercialProperty.addManager(host);                        // Add Host to Property

                System.out.println("Added Successfully");
                System.out.println();
                System.out.println("Display for checking");
                System.out.println("_________________________");
                System.out.println(host.getAssociatedOwners());
                System.out.println(host.getManagedProperties());
                System.out.println(commercialProperty.getManagers());

            }
            else if (choice == 2) {
                int idHost, idProperty;
                Host host = null;
                ResidentialProperty residentialProperty = null;
                boolean checkHost = false, checkProperty = false;

                // Get the Host:
                do{
                    System.out.print("Enter the id of the Host: ");
                    idHost = sc.nextInt();

                    host = (Host) db.getByID(idHost);

                    if (host != null) checkHost = true;
                    else System.out.println("Host does not exists.");
                } while(!checkHost);

                // Display the properties managed by this Host:
                System.out.println("Residential Property managed by this owner: ");
                if(!host.getAssociatedOwners().contains(residentialProperty.getOwner())){
                    System.out.println(host.getManagedProperties());
                }
                System.out.println();

                // Get the Property
                do{
                    System.out.print("Enter the ID of the Property: ");
                    idProperty = sc.nextInt();

                    residentialProperty = (ResidentialProperty) db.getByID(idProperty);

                    if (residentialProperty != null) {
                        if(!host.getManagedProperties().contains(residentialProperty)) checkProperty = true;
                        else System.out.println("Property already managed by this host.");
                    }
                    else System.out.println("Property does not exist in database.");

                } while (!checkProperty);

                host.addManagedProperty(residentialProperty);               // Add Property to Host
                host.addAssociatedOwner(residentialProperty.getOwner());    // Add associated Owner
                residentialProperty.addManager(host);                       // Add Host to Property

                System.out.println("Added Successfully");
                System.out.println();
                System.out.println("Display for checking");
                System.out.println("__________________________");
                System.out.println(host.getAssociatedOwners());
                System.out.println(host.getManagedProperties());
                System.out.println(residentialProperty.getManagers());
            }
        } while(choice != 0);
    }
    public void removeManagedProperties() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("__________________Remove Property From Host____________________");
            System.out.println("1. Remove Commercial Property.");
            System.out.println("2. Remove Residential Property.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Commercial Property
            if (choice == 1){
                int hostID, propertyID;
                boolean findHost = false, findProperty = false;
                Host host = null;
                CommercialProperty commercialProperty = null;

                // Get the Host:
                do {
                    System.out.print("Enter the ID of the Host: ");
                    hostID = sc.nextInt();

                    host = (Host) db.getByID(hostID);

                    if (host != null) findHost = true;
                    else System.out.println("Cannot find the host in the database.");
                } while (!findHost);

                // Print out the list of Property Managed by this Host:
                System.out.println("Commercial Property managed by this owner: ");
                System.out.println(host.getManagedProperties());

                // Get the Properties information:
                do{
                    System.out.print("Enter the ID of the Property: ");
                    propertyID = sc.nextInt();

                    commercialProperty = (CommercialProperty) db.getByID(propertyID);

                    if (commercialProperty != null) findProperty = true;
                    else System.out.println("Cannot find the property in the database.");

                    // Check if the property is  managed by this host
                    if(commercialProperty.getManagers().contains(host)) continue;
                    else {
                        System.out.println("The property is not managed by this host.");
                        findProperty = false;
                    }
                } while (!findProperty);

                host.removeManagedProperty(commercialProperty);             // Remove the Property from the Host
                host.removeAssociatedOwner(commercialProperty.getOwner());  // Remove associated Owner
                commercialProperty.removeManager(host);                     // Remove the manager from the Host

                System.out.println("Removed Successfully");

                // Display the list of property managed by this host
                System.out.println();
                System.out.println("_____________________Display for checking_____________________");
                System.out.println(host.getManagedProperties());
                System.out.println(host.getAssociatedOwners());
                System.out.println(commercialProperty.getManagers());
            }

            else if (choice == 2){
                int hostID, propertyID;
                boolean findHost = false, findProperty = false;
                ResidentialProperty residentialProperty = null;
                Host host = null;

                // Get the Host:
                do{
                    System.out.print("Enter the ID of the Host: ");
                    hostID = sc.nextInt();

                    host = (Host) db.getByID(hostID);

                    if (host != null) findHost = true;
                    else System.out.println("Cannot find the host in the Database.");
                } while (!findHost);

                // Print out the list of property manage by this host:
                System.out.println("Commercial Property managed by this host: ");
                System.out.println(host.getManagedProperties());
                System.out.println();

                // Get the Property
                do{
                    System.out.println("Enter the ID of the Property: ");
                    propertyID = sc.nextInt();

                    residentialProperty = (ResidentialProperty) db.getByID(propertyID);

                    // Check if the property exists in the database
                    if (residentialProperty != null) findProperty = true;
                    else System.out.println("Cannot find the property in the Database.");

                    // Check if the Property is managed by this host
                    if(residentialProperty.getManagers().contains(host)) continue;
                    else {
                        System.out.println("The property is not managed by this host.");
                        findProperty = false;
                    }
                } while (!findProperty);

                host.removeManagedProperty(residentialProperty);               // Remove the Property from the Host
                host.removeAssociatedOwner(residentialProperty.getOwner());    // Remove associated Owner
                residentialProperty.removeManager(host);                       // Remove the manager from the Host

                System.out.println("Added Successfully");
                System.out.println();
                System.out.println("Display for checking");
                System.out.println("__________________________");
                System.out.println(host.getAssociatedOwners());
                System.out.println(host.getManagedProperties());
                System.out.println(residentialProperty.getManagers());
                System.out.println();
            }
        } while (choice != 0);
    }
}
