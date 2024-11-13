package propertymanagement;

import main.java.com.example.propertymanagement.manager.RentalManagerImplementation;
import propertymanagement.manager.RentalAgreementManagerImplementation;
import propertymanagement.util.Formatter;
import propertymanagement.util.UIHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalAgreementManagementSystem {
    public static void main(String[] args) {
        RentalAgreementManagerImplementation rm = new RentalAgreementManagerImplementation();
        UIHelper ui = new UIHelper();
        Formatter formatter = new Formatter();
        Scanner sc = new Scanner(System.in);
        int operationChoice = -1;

        do {
            // Display Main Menu:
            ui.clearConsole();
            ui.displayMainMenu();

            // Prompt's the user choice for input:
            try {
                operationChoice = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println(">> ERROR: Invalid input. Please enter a number between 0 and 4.");
                sc.next(); // Clear the invalid input
                continue;
            }

            // Operations:
            switch (operationChoice) {
                case 1:
                    // Add Rental Agreements logic
                    break;
                case 2:
                    // View Rental Agreements logic
                    break;
                case 3:
                    // Update Rental Agreements' details logic
                    break;
                case 4:
                    // Remove Rental Agreements logic
                case 5:
                    // Search Rental Agreements logic
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        } while (operationChoice != 0);
    }
}
