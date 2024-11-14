package propertymanagement;

import propertymanagement.entity.CommercialProperty;
import propertymanagement.entity.Host;
import propertymanagement.manager.CommericalPropertyManager;
import propertymanagement.manager.HostManager;
import propertymanagement.manager.OwnerManager;
import propertymanagement.manager.ResidentialPropertyManager;
import propertymanagement.resources.Database;

import java.util.Scanner;

public class RentalAgreementManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        OwnerManager om = new OwnerManager(db);
        ResidentialPropertyManager rs = new ResidentialPropertyManager(db);
        CommericalPropertyManager cp = new CommericalPropertyManager(db);
        HostManager h = new HostManager(db);


        int choice = 0;
        do{
            System.out.println("Welcome to the Rental Agreement Management System!");
            System.out.println("Choose Manger");
            System.out.println("1. Owner Manager");
            System.out.println("2. Residential Property Manager");
            System.out.println("3. Commercial Property Manager");
            System.out.println("4. Host Manager");
            System.out.println("5. Tenant Manager");
            System.out.println("5. Rental Agreement Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1){
                int choice_owner_manager = 0;
                do {
                    System.out.println("1. Add Owner.");
                    System.out.println("2. Remove Owner.");
                    System.out.println("3. Edit Owner.");
                    System.out.println("4. View All Owner.");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choice_owner_manager = sc.nextInt();

                    if (choice_owner_manager == 1){
                        int numberOfOwners;
                        System.out.print("Enter the number of owners you want to add: ");
                        numberOfOwners = sc.nextInt();
                        for (int i = 0; i < numberOfOwners; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st owner");
                            om.add();
                        }
                    }
                    else if (choice_owner_manager == 2){
                        int numberOfOwners;
                        System.out.print("Enter the number of owners you want to remove: ");
                        numberOfOwners = sc.nextInt();

                        for (int i = 0; i < numberOfOwners; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st owner");
                            om.remove();
                        }
                    }
                    else if (choice_owner_manager == 3){
                        int numberOfOwners;
                        System.out.print("Enter the number of owners you want to edit: ");
                        numberOfOwners = sc.nextInt();
                        for (int i = 0; i < numberOfOwners; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st owner you want to update");
                            om.update();
                        }
                    }
                    else if (choice_owner_manager == 4){
                        om.displayAll();
                    }
                } while (choice_owner_manager != 0);
            }
            else if (choice == 2){
                int choice_residential_property = 0;
                do {
                    System.out.println("1. Add Residential Property.");
                    System.out.println("2. Remove Residential Property.");
                    System.out.println("3. Edit Residential Property.");
                    System.out.println("4. View All Residential Property.");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choice_residential_property = sc.nextInt();

                    if (choice_residential_property == 1){
                        int numberOfResidentials;
                        System.out.print("Enter the number of residentials you want to add: ");
                        numberOfResidentials = sc.nextInt();
                        for (int i = 0; i < numberOfResidentials; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st residential property");
                            rs.add();
                        }
                    }
                    else if (choice_residential_property == 2){
                        int numberOfResidentials;
                        System.out.print("Enter the number of residentials you want to remove: ");
                        numberOfResidentials = sc.nextInt();
                        for (int i = 0; i < numberOfResidentials; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st residential property");
                            rs.remove();
                        }
                    }
                    else if (choice_residential_property == 3){
                        int numberOfResidentials;
                        System.out.print("Enter the number of residentials you want to edit: ");
                        numberOfResidentials = sc.nextInt();
                        for (int i = 0; i < numberOfResidentials; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st residential property");

                        }
                    }
                    else if (choice_residential_property == 4){
                        rs.displayAll();
                    }
                } while (choice_residential_property != 0);
            }
            else if (choice == 3){
                int choice_commercial_property = 0;
                do {
                    System.out.println("1. Add Commercial Property.");
                    System.out.println("2. Remove Commercial Property.");
                    System.out.println("3. Edit Commercial Property.");
                    System.out.println("4. View All Commercial Property.");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choice_commercial_property = sc.nextInt();

                    if (choice_commercial_property == 1){
                        int numberOfCommercials;
                        System.out.print("Enter the number of commercials you want to add: ");
                        numberOfCommercials = sc.nextInt();
                        for (int i = 0; i < numberOfCommercials; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st commercial property");
                            cp.add();
                        }
                    }
                    else if (choice_commercial_property == 2){
                        int numberOfCommercials;
                        System.out.print("Enter the number of commercials you want to remove: ");
                        numberOfCommercials = sc.nextInt();
                        for (int i = 0; i < numberOfCommercials; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st commercial property");
                            cp.remove();
                        }
                    }
                    else if (choice_commercial_property == 3) {
                        int numberOfCommercials;
                        System.out.print("Enter the number of commercials you want to edit: ");
                        numberOfCommercials = sc.nextInt();
                        for (int i = 0; i < numberOfCommercials; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st commercial property");
                            cp.update();
                        }
                    }
                    else if (choice_commercial_property == 4){
                        cp.displayAll();
                    }
                } while (choice_commercial_property != 0);

            }
            else if (choice == 4){

            } else if (choice == 5) {

            }
        } while (choice != 0);


    }

}
