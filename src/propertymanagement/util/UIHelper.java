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

    public static void AddRentalAgreements(){

    }
    public static void viewRentalAgreements(){

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
