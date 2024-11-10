package main.java.com.example.propertymanagement.util;

import main.java.com.example.propertymanagement.entity.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Your Name - Your Student ID
 */
public class UIHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayHeader(String title) {
        System.out.println("\n=== " + title + " ===");
    }

    public static void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public static void displaySuccess(String message) {
        System.out.println("Success: " + message);
    }

    public static void displayTenantList(List<Tenant> tenants) {
        displayHeader("Tenant List");
        if (tenants.isEmpty()) {
            System.out.println("No tenants found.");
            return;
        }

        System.out.printf("%-10s %-20s %-15s %-25s %-15s%n",
                "ID", "Name", "Phone", "Email", "ID Number");
        System.out.println("-".repeat(85));

        for (Tenant tenant : tenants) {
            System.out.printf("%-10s %-20s %-15s %-25s %-15s%n",
                    tenant.getId(),
                    tenant.getFullName(),
                    tenant.getPhoneNumber(),
                    tenant.getEmail(),
                    tenant.getIdNumber());
        }
    }

    public static void displayPropertyList(List<Property> properties) {
        displayHeader("Property List");
        if (properties.isEmpty()) {
            System.out.println("No properties found.");
            return;
        }

        System.out.printf("%-10s %-30s %-15s %-20s%n",
                "ID", "Address", "Status", "Owner");
        System.out.println("-".repeat(75));

        for (Property property : properties) {
            System.out.printf("%-10s %-30s %-15s %-20s%n",
                    property.getId(),
                    property.getAddress(),
                    property.getStatus(),
                    property.getOwner().getFullName());
        }
    }

    public static void displayRentalAgreementList(List<RentalAgreement> agreements) {
        displayHeader("Rental Agreement List");
        if (agreements.isEmpty()) {
            System.out.println("No rental agreements found.");
            return;
        }

        System.out.printf("%-10s %-20s %-20s %-15s %-12s%n",
                "ID", "Tenant", "Property", "Monthly Rent", "Status");
        System.out.println("-".repeat(77));

        for (RentalAgreement agreement : agreements) {
            System.out.printf("%-10s %-20s %-20s $%-14.2f %-12s%n",
                    agreement.getId(),
                    agreement.getTenant().getFullName(),
                    agreement.getProperty().getId(),
                    agreement.getMonthlyRent(),
                    agreement.isActive() ? "Active" : "Inactive");
        }
    }

    public static void displayPaymentList(List<Payment> payments) {
        displayHeader("Payment List");
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        System.out.printf("%-10s %-20s %-15s %-15s %-15s%n",
                "ID", "Agreement ID", "Amount", "Date", "Method");
        System.out.println("-".repeat(75));

        for (Payment payment : payments) {
            System.out.printf("%-10s %-20s $%-14.2f %-15s %-15s%n",
                    payment.getId(),
                    payment.getRentalAgreement().getId(),
                    payment.getAmount(),
                    InputValidator.formatDate(payment.getPaymentDate()),
                    payment.getPaymentMethod());
        }
    }

    public static String promptString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    public static int promptInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayError("Please enter a valid number");
            }
        }
    }

    public static double promptDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                displayError("Please enter a valid number");
            }
        }
    }

    public static boolean promptBoolean(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            displayError("Please enter 'y' or 'n'");
        }
    }

    public static void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
