package propertymanagement.manager;

import propertymanagement.entity.Host;
import propertymanagement.resources.Database;

import java.util.List;
import java.util.Scanner;

import static propertymanagement.resources.Database.IDGenerator;
import static propertymanagement.util.UIHelper.parseDate;

public class HostManager implements Manager{
    private Database db;
    List<Host> h;

    public HostManager(Database db) {
        this.db = db;
        this.h = h;
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter host's full name: ");
        String name = sc.nextLine();

        System.out.println("Enter host's date of birth(DD/MM/YYYY): ");
        String dateOfBirth = sc.nextLine();

        System.out.println("Enter host's EMAIL address: ");
        String email = sc.nextLine();

        System.out.println("Enter host's phone number: ");
        String phone = sc.nextLine();

        System.out.println("Enter host's idNumber: ");
        String idNumber = sc.nextLine();

        int id = IDGenerator(Host.class);

        Host host = new Host(id, name, parseDate(dateOfBirth), email, phone, idNumber);

        if (h.add(host)) {
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
            if (h.remove(o)) {
                System.out.println("Host removed successfully from database");
            }
            else System.out.println("Cannot remove host from database");
        }
        else System.out.println("Cannot find the host");
    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the id of the host you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter host's full name: ");
        String name = sc.nextLine();

        System.out.println("Enter host's date of birth(DD/MM/YYYY): ");
        String dateOfBirth = sc.nextLine();

        System.out.println("Enter host's EMAIL address: ");
        String email = sc.nextLine();

        System.out.println("Enter host's phone number: ");
        String phone = sc.nextLine();

        System.out.println("Enter host's idNumber: ");
        String idNumber = sc.nextLine();

        Host o = (Host) db.getByID(id);
        o.setFullName(name);
        o.setDateOfBirth(parseDate(dateOfBirth));
        o.setEmail(email);
        o.setPhoneNumber(phone);
        o.setIdNumber(idNumber);
    }

    @Override
    public void displayAll() {
        for (Host h : h) {
            System.out.println(h);
        }
    }
}
