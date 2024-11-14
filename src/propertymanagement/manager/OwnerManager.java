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
    List<Owner> owner = db.getAll(Owner.class);
    List<CommercialProperty> cp = db.getAll(CommercialProperty.class);
    List<ResidentialProperty> rp = db.getAll(ResidentialProperty.class);


    public OwnerManager(Database db) {
        this.db = db;
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
        System.out.print("Enter owner's idNumber: ");
        String idNumber = sc.nextLine();

        int ID = IDGenerator(Owner.class);
        Owner o = new Owner(ID, fullName, parseDate(dateOfBirth), email, phoneNumber, idNumber);
        if(owner.add(o)) System.out.println("Added Owner to database Successfully");
        else System.out.println("Failed to add Owner to Database");
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to input the ID of the owner:
        System.out.print("Enter owner's id: ");
        int id = sc.nextInt();

        for (Owner o : owner) {
            if (o.getId() == id) {
                owner.remove(o);
                System.out.println("Owner deleted successfully from database");
            }
        }
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

        System.out.print("Enter owner's idNumber: ");
        String idNumber = sc.nextLine();

        for (Owner o : owner) {
            if (o.getId() == id) {
                // replace the old oject with the whole new object:
                o.setFullName(fullName);
                o.setDateOfBirth(parseDate(dateOfBirth));
                o.setEmail(email);
                o.setPhoneNumber(phoneNumber);
                o.setIdNumber(idNumber);
                break;
            }
        }
    }

    @Override
    public void displayAll() {
        for (Owner o : owner) System.out.println(o);
    }

    // Add Properties:
    public void addCommercialPropertyToOwner() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Owner's ID you want to add Commercial Property: ");
        int ownerId = sc.nextInt();
        System.out.print("Enter commercial property's id: ");
        int commId = sc.nextInt();

        for (Owner o : owner) {
            if (o.getId() == ownerId) {
                for (CommercialProperty c : cp){
                    if (c.getId() == commId) {
                        o.addOwnedProperty(c);
                        System.out.println("Added Commercial Property Successfully");
                    }
                }
            }
            else System.out.println("Cannot find owner.");
        }
    }
    public void addResidentialProperties(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Owner's ID you want to add Residential Property: ");
        int ownerId = sc.nextInt();
        System.out.print("Enter Residential property's id: ");
        int resId = sc.nextInt();
        for (Owner o : owner) {
            if (o.getId() == ownerId) {
                for (ResidentialProperty r : rp){
                    if (r.getId() == resId) {
                        o.addOwnedProperty(r);
                        System.out.println("Added Residential Property Successfully");
                    }
                }
            }
            else System.out.println("Cannot find owner.");
        }
    }
}
