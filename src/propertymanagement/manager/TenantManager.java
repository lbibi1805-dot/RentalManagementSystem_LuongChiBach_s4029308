package propertymanagement.manager;

import propertymanagement.entity.Tenant;
import propertymanagement.resources.Database;

import java.util.List;
import java.util.Scanner;

import static propertymanagement.resources.Database.IDGenerator;
import static propertymanagement.util.UIHelper.parseDate;

public class TenantManager implements Manager {
    private Database db;
    List<Tenant> t;

    public TenantManager(Database db) {
        this.db = db;
        this.t = db.getAll(Tenant.class);
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Tenant Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Tenant's date of birth: ");
        String dateOfBirth = sc.nextLine();

        System.out.print("Enter Tenant's email: ");
        String email = sc.nextLine();

        System.out.print("Enter Tenant's phone number: ");
        String phoneNumber = sc.nextLine();

        int id = IDGenerator(Tenant.class);

        Tenant tenant = new Tenant(id, name, parseDate(dateOfBirth), email, phoneNumber);

        if (db.add(tenant)) System.out.println("Tenant added Successfully to database");
        else System.out.println("Cannot add tenant to the database");
    }

    @Override
    public void remove() {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the Tenant ID:
        System.out.print("Enter the ID of the Tenant that you want to remove: ");
        int id = sc.nextInt();

        Tenant o = (Tenant) db.getByID(id);
        if(o != null) {
            if (t.remove(o)) System.out.println("Tenant removed successfully from database");
            else System.out.println("Cannot remove tenant from the database");
        }
        else System.out.println("Cannot find the Tenant from database. ");
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the id of the tenant you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Tenant Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Tenant's date of birth: ");
        String dateOfBirth = sc.nextLine();

        System.out.print("Enter Tenant's email: ");
        String email = sc.nextLine();

        System.out.print("Enter Tenant's phone number: ");
        String phoneNumber = sc.nextLine();

        Tenant o = (Tenant) db.getByID(id);

        o.setFullName(name);
        o.setDateOfBirth(parseDate(dateOfBirth));
        o.setEmail(email);
        o.setPhoneNumber(phoneNumber);
    }

    @Override
    public void displayAll() {
        for (Tenant t : t) {
            System.out.println(t);
        }
    }
}
