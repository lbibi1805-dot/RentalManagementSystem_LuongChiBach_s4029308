package propertymanagement.manager;

import propertymanagement.entity.ResidentialProperty;
import propertymanagement.resources.Database;

import java.util.List;
import java.util.Scanner;

public class ResidentialPropertyManagement implements Manager{
    private Database db;
    List<ResidentialProperty> rp = db.getAll(ResidentialProperty.class);

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the property's address: ");
        String address = sc.nextLine();
        System.out.println("Select the residential status: ");
        System.out.println("1. Enter 1 for AVAILABLE");
        System.out.println("2. Enter 2 for RENTED");
        System.out.println("3. Enter 3 for MAINTENANCE");
        int status = sc.nextInt();

    }

    @Override
    public void remove() {
    }

    @Override
    public void update() {

    }

    @Override
    public void displayAll() {

    }
}
