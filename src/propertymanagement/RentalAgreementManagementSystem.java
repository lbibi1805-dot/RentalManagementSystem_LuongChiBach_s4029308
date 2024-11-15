package propertymanagement;

import propertymanagement.entity.CommercialProperty;
import propertymanagement.entity.Host;
import propertymanagement.entity.Tenant;
import propertymanagement.manager.*;
import propertymanagement.resources.Database;

import java.util.Scanner;

import static propertymanagement.util.UIDisplay.systemMenu;

public class RentalAgreementManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        OwnerManager om = new OwnerManager(db);
        ResidentialPropertyManager rs = new ResidentialPropertyManager(db);
        CommericalPropertyManager cp = new CommericalPropertyManager(db);
        HostManager h = new HostManager(db);
        TenantManager t = new TenantManager(db);

        int choice = 0;

        do{
            systemMenu();
            choice = sc.nextInt();

            if (choice == 1){
                int choice_owner_manager = 0;
                do {
                    System.out.println("1. Add Owner.");
                    System.out.println("2. Remove Owner.");
                    System.out.println("3. Edit Owner.");
                    System.out.println("4. View All Owner.");
                    System.out.println("5. Add Properties.");
                    System.out.println("6. Remove owned Properties.");
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
                    else if (choice_owner_manager == 5){
                        om.addProperty();
                    }
                    else if (choice_owner_manager == 6){
                        om.removeProperty();
                    }
                } while (choice_owner_manager != 0);
            }                                                       // Add Properties

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
                            rs.update();
                        }
                    }
                    else if (choice_residential_property == 4){
                        rs.displayAll();
                    }
                } while (choice_residential_property != 0);
            }                                                  // Need Implementations:

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

            }                                                  // Need Implementations:

            else if (choice == 4){
                int choiceHost = 0;
                do{
                    System.out.println("1. Add Host");
                    System.out.println("2. Remove Host");
                    System.out.println("3. Edit Host");
                    System.out.println("4. View All Host");
                    System.out.println("5. Add Managed Properties");
                    System.out.println("6. Add Rental Agreements");
                    System.out.println("7. Add Rental Agreements");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choiceHost = sc.nextInt();

                    if (choiceHost == 1){
                        int numberOfHosts;
                        System.out.print("Enter the number of hosts you want to add: ");
                        numberOfHosts = sc.nextInt();

                        for (int i = 0; i < numberOfHosts; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st host");
                            h.add();
                        }
                    }
                    else if (choiceHost == 2){
                        int numberOfHosts;
                        System.out.print("Enter the number of hosts you want to remove: ");
                        numberOfHosts = sc.nextInt();

                        for (int i = 0; i < numberOfHosts; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st host");
                            h.remove();
                        }
                    }
                    else if (choiceHost == 3){
                        int numberOfHosts;
                        System.out.print("Enter the number of hosts you want to edit: ");
                        numberOfHosts = sc.nextInt();

                        for (int i = 0; i < numberOfHosts; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st host");
                            h.update();
                        }
                    }
                    else if (choiceHost == 4) {
                        h.displayAll();
                    }
                    else if (choiceHost == 5) {
                        // enter code here
                    }
                    else if (choiceHost == 6){
                        // enter code here
                    }
                    else if (choiceHost == 7){
                        // enter code here
                    }
                } while (choice != 0);
            }                                                  // Need Implementations:

            else if (choice == 5) {
                int choiceTenant = 0;
                do {
                    System.out.println("1. Add Tenant");
                    System.out.println("2. Remove Tenant");
                    System.out.println("3. Edit Tenant");
                    System.out.println("4. View All Tenant");
                    System.out.println("5. Add Rental Agreement");
                    System.out.println("6. Add Payment");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");
                    choiceTenant = sc.nextInt();

                    if (choiceTenant == 1){
                        int numberOfTenants;
                        System.out.print("Enter the number of tenants you want to add: ");
                        numberOfTenants = sc.nextInt();
                        for (int i = 0; i < numberOfTenants; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st tenant");
                            t.add();
                        }
                    }

                    else if (choiceTenant == 2){
                        int numberOfTenants;
                        System.out.print("Enter the number of tenants you want to remove: ");
                        numberOfTenants = sc.nextInt();
                        for (int i = 0; i < numberOfTenants; i++){
                            System.out.println("Enter information for the " + (i + 1) + "st tenant");
                            t.remove();
                        }
                    }

                    else if (choiceTenant == 3){
                        int numberOfTenants;
                        System.out.print("Enter the number of tenants you want to edit: ");
                        numberOfTenants = sc.nextInt();
                        for (int i = 0; i < numberOfTenants; i++){
                            t.update();
                        }
                    }

                    else if (choiceTenant == 4){
                        t.displayAll();
                    }

                    else if (choiceTenant == 5){
                        // Enter Code Here
                    }

                    else if (choiceTenant == 6){
                        // Enter Code Here
                    }
                } while (choiceTenant != 0);
            }                                                 // Need Implementations:

            else if (choice == 6){
                System.out.println("Welcome to the Rental Agreement Management System");
                System.out.println("1. Create Rental Agreement");
                System.out.println("2. Edit Rental Agreement");
                System.out.println("3. View Rental Agreements");
                System.out.println("4. Add Rental Agreement");
                System.out.println("5. Search Rental Agreement");
                System.out.println("___________________________________________________");
                System.out.println("6. View all Owners");
                System.out.println("7. View all Hosts");
                System.out.println("8. View all Tenants");
                System.out.println("9. View all Payments");
                System.out.println("10. View all Properties");
                System.out.println("0. Exit");

                int rentalAgreementChoice = sc.nextInt();

                if (rentalAgreementChoice == 1){
                    // Enter Code Here
                }

                else if (rentalAgreementChoice == 2){
                    // Enter Your Code Here
                }

                else if (rentalAgreementChoice == 3){
                    // Enter Your code Here
                }

                else if(rentalAgreementChoice == 4){
                    // Enter Your Code Here
                }

                else if (rentalAgreementChoice == 5) {
                    // Enter Your Code Here
                }

                else if (rentalAgreementChoice == 6) {
                    // Enter Code Here
                }

                else if (rentalAgreementChoice == 7) {
                    // Enter Code Here
                }

                else if (rentalAgreementChoice == 8) {
                    // Enter COde Here
                }

                else if (rentalAgreementChoice == 9) {
                    // Enter Code Here
                }

                else if (rentalAgreementChoice == 10) {
                    // Enter Code Here
                }
            }                                                  // Need Implementations:

        } while (choice != 0);

         db.saveData();
    }

}
