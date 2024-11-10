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

    // Tenant Management
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
                    Tenant newTenant = createTenant();
                    rentalManager.addTenant(newTenant);
                    System.out.println("Tenant added successfully!");
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

    // Host Management
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
                    Host newHost = createHost();
                    rentalManager.addHost(newHost);
                    System.out.println("Host added successfully!");
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

    // Owner Management
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
                    Owner newOwner = createOwner();
                    rentalManager.addOwner(newOwner);
                    System.out.println("Owner added successfully!");
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

    // Property Management
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
                    Property newProperty = createProperty();
                    if (newProperty != null) {
                        rentalManager.addProperty(newProperty);
                        System.out.println("Property added successfully!");
                    }
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

    // Rental Agreement Management
    private void manageRentalAgreements() {
        while (true) {
            System.out.println("\n=== Rental Agreement Management ===");
            System.out.println("1. Create Rental Agreement");
            System.out.println("2. Update Rental Agreement");
            System.out.println("3. Delete Rental Agreement");
            System.out.println("4. View All Rental Agreements");
            System.out.println("5. View Active Rental Agreements");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    RentalAgreement newAgreement = createRentalAgreement();
                    if (newAgreement != null) {
                        rentalManager.addRentalAgreement(newAgreement);
                        System.out.println("Rental Agreement created successfully!");
                    }
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

    // Payment Management
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
                    Payment newPayment = createPayment();
                    if (newPayment != null) {
                        rentalManager.addPayment(newPayment);
                        System.out.println("Payment recorded successfully!");
                    }
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
    private Tenant createTenant() {
        System.out.println("\nEnter Tenant Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        return new Tenant(generateId(), name, email, phone);
    }

    private Host createHost() {
        System.out.println("\nEnter Host Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        return new Host(generateId(), name, email, phone);
    }

    private Owner createOwner() {
        System.out.println("\nEnter Owner Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        return new Owner(generateId(), name, email, phone);
    }

    private Property createProperty() {
        System.out.println("\nEnter Property Details:");
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Owner ID: ");
        String ownerId = scanner.nextLine();

        Owner owner = rentalManager.getOwnerById(ownerId);
        if (owner == null) {
            System.out.println("Owner not found!");
            return null;
        }

        return new Property(generateId(), address, Property.Status.AVAILABLE, owner);
    }

    private RentalAgreement createRentalAgreement() {
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
            return null;
        }

        System.out.print("Start Date (dd/MM/yyyy): ");
        Date startDate = parseDate(scanner.nextLine());
        System.out.print("End Date (dd/MM/yyyy): ");
        Date endDate = parseDate(scanner.nextLine());
        System.out.print("Monthly Rent: ");
        double monthlyRent = scanner.nextDouble();
        scanner.nextLine();

        return new RentalAgreement(generateId(), tenant, property, host, startDate, endDate, monthlyRent);
    }

    private Payment createPayment() {
        System.out.println("\nEnter Payment Details:");
        System.out.print("Rental Agreement ID: ");
        String agreementId = scanner.nextLine();

        RentalAgreement agreement = rentalManager.getRentalAgreementById(agreementId);
        if (agreement == null) {
            System.out.println("Rental Agreement not found!");
            return null;
        }

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        return new Payment(generateId(), agreement, amount, new Date());
    }

    // Helper methods for updating entities
    private void updateTenant() {
        System.out.print("Enter tenant ID to update: ");
        String id = scanner.nextLine();
        Tenant tenant = rentalManager.getTenantById(id);
        if (tenant == null) {
            System.out.println("Tenant not found.");
            return;
        }

        System.out.println("Enter new details (press enter to keep current value):");
        System.out.print("Name (" + tenant.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) tenant.setName(name);

        System.out.print("Email (" + tenant.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) tenant.setEmail(email);

        System.out.print("Phone (" + tenant.getPhone() + "): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) tenant.setPhone(phone);

        rentalManager.updateTenant(tenant);
        System.out.println("Tenant updated successfully.");
    }

    // Similar update methods for other entities...

    // Helper methods for deleting entities
    private void deleteTenant() {
        System.out.print("Enter tenant ID to delete: ");
        String id = scanner.nextLine();
        if (rentalManager.removeTenant(id)) {
            System.out.println("Tenant deleted successfully.");
        } else {
            System.out.println("Failed to delete tenant. Tenant not found or has active agreements.");
        }
    }

    // Similar delete methods for other entities...

    // Helper methods for viewing entities
    private void viewAllTenants() {
        List<Tenant> tenants = rentalManager.getAllTenants();
        if (tenants.isEmpty()) {
            System.out.println("No tenants found.");
        } else {
            System.out.println("\nAll Tenants:");
            for (Tenant tenant : tenants) {
                System.out.println(tenant);
            }
        }
    }

    private voi
s