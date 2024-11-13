package main.java.com.example.propertymanagement;

import main.java.com.example.propertymanagement.entity.*;
import main.java.com.example.propertymanagement.manager.RentalManager;
import main.java.com.example.propertymanagement.manager.RentalManagerImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PropertyManagementSystem {
    private RentalManager rentalManager;
    private Scanner scanner;

    public PropertyManagementSystem() {
        this.rentalManager = new RentalManagerImpl();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageTenants();
                    break;
                case 2:
                    manageHosts();
                    break;
                case 3:
                    manageOwners();
                    break;
                case 4:
                    manageProperties();
                    break;
                case 5:
                    manageRentalAgreements();
                    break;
                case 6:
                    managePayments();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using Property Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n=== Property Management System ===");
        System.out.println("1. Manage Tenants");
        System.out.println("2. Manage Hosts");
        System.out.println("3. Manage Owners");
        System.out.println("4. Manage Properties");
        System.out.println("5. Manage Rental Agreements");
        System.out.println("6. Manage Payments");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private void manageTenants() {
        while (true) {
            System.out.println("\n=== Tenant Management ===");
            System.out.println("1. Add Tenant");
            System.out.println("2. Update Tenant");
            System.out.println("3. Delete Tenant");
            System.out.println("4. View All Tenants");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createTenant();
                    break;
                case 2:
                    updateTenant();
                    break;
                case 3:
                    deleteTenant();
                    break;
                case 4:
                    viewAllTenants();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageHosts() {
        while (true) {
            System.out.println("\n=== Host Management ===");
            System.out.println("1. Add Host");
            System.out.println("2. Update Host");
            System.out.println("3. Delete Host");
            System.out.println("4. View All Hosts");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createHost();
                    break;
                case 2:
                    updateHost();
                    break;
                case 3:
                    deleteHost();
                    break;
                case 4:
                    viewAllHosts();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageOwners() {
        while (true) {
            System.out.println("\n=== Owner Management ===");
            System.out.println("1. Add Owner");
            System.out.println("2. Update Owner");
            System.out.println("3. Delete Owner");
            System.out.println("4. View All Owners");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createOwner();
                    break;
                case 2:
                    updateOwner();
                    break;
                case 3:
                    deleteOwner();
                    break;
                case 4:
                    viewAllOwners();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageProperties() {
        while (true) {
            System.out.println("\n=== Property Management ===");
            System.out.println("1. Add Property");
            System.out.println("2. Update Property");
            System.out.println("3. Delete Property");
            System.out.println("4. View All Properties");
            System.out.println("5. View Available Properties");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createProperty();
                    break;
                case 2:
                    updateProperty();
                    break;
                case 3:
                    deleteProperty();
                    break;
                case 4:
                    viewAllProperties();
                    break;
                case 5:
                    viewAvailableProperties();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageRentalAgreements() {
        while (true) {
            System.out.println("\n=== Rental Agreement Management ===");
            System.out.println("1. Create Agreement");
            System.out.println("2. Update Agreement");
            System.out.println("3. Delete Agreement");
            System.out.println("4. View All Agreements");
            System.out.println("5. View Active Agreements");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createRentalAgreement();
                    break;
                case 2:
                    updateRentalAgreement();
                    break;
                case 3:
                    deleteRentalAgreement();
                    break;
                case 4:
                    viewAllRentalAgreements();
                    break;
                case 5:
                    viewActiveRentalAgreements();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void managePayments() {
        while (true) {
            System.out.println("\n=== Payment Management ===");
            System.out.println("1. Record Payment");
            System.out.println("2. Update Payment");
            System.out.println("3. Delete Payment");
            System.out.println("4. View All Payments");
            System.out.println("5. View Payments by Tenant");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createPayment();
                    break;
                case 2:
                    updatePayment();
                    break;
                case 3:
                    deletePayment();
                    break;
                case 4:
                    viewAllPayments();
                    break;
                case 5:
                    viewPaymentsByTenant();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper methods for creating entities
    private void createTenant() {
        System.out.println("\nEnter Tenant Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Tenant tenant = new Tenant(generateId(), name, email, phone);
        rentalManager.addTenant(tenant);
        System.out.println("Tenant added successfully!");
    }

    private void createHost() {
        System.out.println("\nEnter Host Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Host host = new Host(generateId(), name, email, phone);
        rentalManager.addHost(host);
        System.out.println("Host added successfully!");
    }

    private void createOwner() {
        System.out.println("\nEnter Owner Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Owner owner = new Owner(generateId(), name, email, phone);
        rentalManager.addOwner(owner);
        System.out.println("Owner added successfully!");
    }

    private void createProperty() {
        System.out.println("\nEnter Property Details:");
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Owner ID: ");
        String ownerId = scanner.nextLine();

        Owner owner = rentalManager.getOwnerById(ownerId);
        if (owner == null) {
            System.out.println("Owner not found!");
            return;
        }

        Property property = new Property(generateId(), address, Property.Status.AVAILABLE, owner);
        rentalManager.addProperty(property);
        System.out.println("Property added successfully!");
    }

    private void createRentalAgreement() {
        System.out.println("\nEnter Rental Agreement Details:");
        System.out.print("Tenant ID: ");
        String tenantId = scanner.nextLine();
        System.out.print("Property ID: ");
        String propertyId = scanner.nextLine();
        System.out.print("Host ID: ");
        String hostId = scanner.nextLine();

        Tenant tenant = rentalManager.getTenantById(tenantId);
        Property property = rentalManager.getPropertyById(propertyId);
        Host host = rentalManager.getHostById(hostId);

        if (tenant == null || property == null || host == null) {
            System.out.println("Invalid tenant, property, or host ID!");
            return;
        }

        System.out.print("Start Date (dd/MM/yyyy): ");
        Date startDate = parseDate(scanner.nextLine());
        System.out.print("End Date (dd/MM/yyyy): ");
        Date endDate = parseDate(scanner.nextLine());
        System.out.print("Monthly Rent: ");
        double monthlyRent = scanner.nextDouble();
        scanner.nextLine();

        RentalAgreement agreement = new RentalAgreement(generateId(), tenant, property, host, startDate, endDate, monthlyRent);
        rentalManager.addRentalAgreement(agreement);
        System.out.println("Rental Agreement created successfulQly!");
    }

    private void createPayment() {
        System.out.println("\nEnter Payment Details:");
        System.out.print("Rental Agreement ID: ");
        String agreementId = scanner.nextLine();

        RentalAgreement agreement = rentalManager.getRentalAgreementById(agreementId);
        if (agreement == null) {
            System.out.println("Rental Agreement not found!");
            return;
        }

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Payment payment = new Payment(generateId(), agreement, amount, new Date());
        rentalManager.addPayment(payment);
        System.out.println("Payment recorded successfully!");
    }

    // Helper methods
    private String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }


    // Main method
    public static void main(String[] args) {
        PropertyManagementSystem system = new PropertyManagementSystem();
        system.start();
    }
}


