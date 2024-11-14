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

        System.out.print("Enter owner's idNumber: ");
        String idNumber = sc.nextLine();

        Owner o = (Owner) db.getByID(id);
        if (o != null){
            o.setFullName(fullName);
            o.setDateOfBirth(parseDate(dateOfBirth));
            o.setEmail(email);
            o.setPhoneNumber(phoneNumber);
            o.setIdNumber(idNumber);
        } else System.out.println("Cannot find the owner");
    }

    @Override
    public void displayAll() {
        for (Owner o : owner) System.out.println(o);
    }

}
