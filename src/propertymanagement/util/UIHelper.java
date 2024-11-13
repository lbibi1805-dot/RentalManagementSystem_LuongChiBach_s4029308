package propertymanagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UIHelper {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Unable to clear console.");
        }
    }

    // Display Methods:
    public static void displayMainMenu(){
        System.out.println("______________________________________________________");
        System.out.println("         RENTAL AGREEMENT MANAGEMENT SYSTEM           ");
        System.out.println("                                                v1.0.0");
        System.out.println("                           Developed by Luong Chi Bach");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------MENU ------------------------_");
        System.out.println("Please choose one option to continue");
        System.out.println("1. Add Rental Agreements.");
        System.out.println("2. View Rental Agreements.");
        System.out.println("3. Update Rental Agreements' details.");
        System.out.println("4. Remove Rental Agreements.");
        System.out.println("5. Search Rental Agreements.");
        System.out.println("0. Exit");
        System.out.println("______________________________________________________");
        // Prompt the user' input:
        System.out.println(">> Enter your choice: ");
    }

    // Date formatting Method:
    public static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }
    }
}
