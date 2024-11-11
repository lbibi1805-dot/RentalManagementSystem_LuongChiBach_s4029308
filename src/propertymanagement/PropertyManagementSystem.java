package propertymanagement;

import propertymanagement.entity.Host;
import propertymanagement.entity.Property;
import propertymanagement.entity.Tenant;
import propertymanagement.manager.RentalManager;
import propertymanagement.manager.RentalManagerImplementation;
import propertymanagement.util.InputValidator;
import propertymanagement.util.UIHelper;

import java.util.Date;
import java.util.Scanner;

public class PropertyManagementSystem {
    // Call out Classes Obj;
    private RentalManager rentalManager;
    private Scanner scanner;
    private UIHelper uiHelper;
    private InputValidator inputValidator;

    // Initialize:
    public PropertyManagementSystem() {
        this.rentalManager = new RentalManagerImplementation();
        this.scanner = new Scanner(System.in);
    }

    // Program's flow method:
    public void start(){
        boolean running = true;

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                createRentalAgreement();
                break;
            case 2:
                updateRentalAgreement();
                break;
            case 3:
                viewAllRentalAgreement();
                break;
            case 4:
                viewSpecificAgreement();
            case 0:
                return;
            default:
                System.out.print("Invalid choice/input.");
                uiHelper.displayError("The input should be an integer [0 to 4].");
        }

    }

    private void displayMainMenu() {
        System.out.println("\n=== Rental Management System ===");
        System.out.println("1. Create New Rental Agreement.");
        System.out.println("2. Update Rental Agreements.");
        System.out.println("3. View All Rental Agreements List.");
        System.out.println("4. View Specific Rental Agreement's information.");
        System.out.println("5. Delete Rental Agreements");
        System.out.println("0. Exit.");
        System.out.print("Enter your choice: ");
    }

    // Features Function:
    private void createRentalAgreement() {
        // Prompt the user to enter the information
        System.out.println("\nEnter Rental Agreement Details:");
        System.out.print("Tenant ID: ");
        String tenantId = scanner.nextLine();
        System.out.print("Property ID: ");
        String propertyId = scanner.nextLine();
        System.out.print("Host ID: ");
        String hostId = scanner.nextLine();

        // Initialize objects
        Tenant tenant = rentalManager.getTenantById(tenantId);
        Property property = rentalManager.getPropertyById(propertyId);
        Host host = rentalManager.getHostById(hostId);

        // Check information's validation
        if (tenant == null || property == null || host == null) {
            System.out.println("Invalid tenant, property, or host ID!");
            return;
        }

        //
        System.out.print("Start Date (dd/MM/yyyy): ");
        Date startDate = inputValidator.parseDate(scanner.nextLine());
        System.out.print("End Date (dd/MM/yyyy): ");
        Date endDate = inputValidator.parseDate(scanner.nextLine());
        System.out.print("Monthly Rent: ");
        double monthlyRent = scanner.nextDouble();
        scanner.nextLine();

    }
    public void updateRentalAgreement() {}
    public void viewAllRentalAgreement() {}
    public void viewSpecificAgreement(){}
    public void deleteRentalAgreement() {}

    // Main Method:
    public static void main(String[] args){
        PropertyManagementSystem system = new PropertyManagementSystem();
        system.start();
    }
}
