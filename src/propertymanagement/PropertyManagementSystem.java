package propertymanagement;

import propertymanagement.entity.*;
import propertymanagement.manager.RentalManagerImplementation2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PropertyManagementSystem {
    // UI Methods:
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

    // Date Formatting Method:
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

    public static void main(String[] args) {
        // Create objects first:
        // Owner:
        Owner o1 = new Owner("O001", "Luong Chi Bach", parseDate("18/05/2005"), "chibach@gmail.com", "0989981805", "001206002239");
        Owner o2 = new Owner("O002", "Nguyen Thi Lan", parseDate("25/12/1985"), "lannguyen@gmail.com", "0932134567", "002303004567");
        Owner o3 = new Owner("O003", "Tran Minh Tuan", parseDate("15/03/1990"), "tuantm@gmail.com", "0912345678", "003303004567");
        Owner o4 = new Owner("O004", "Le Thi Mai", parseDate("22/07/1980"), "maile@gmail.com", "0905678901", "004303004567");
        Owner o5 = new Owner("O005", "Pham Minh Tu", parseDate("05/10/1995"), "tupham@gmail.com", "0943456789", "005303004567");
        Owner o6 = new Owner("O006", "Hoang Thi Lan", parseDate("12/11/1992"), "lanhoang@gmail.com", "0978765432", "006303004567");
        Owner o7 = new Owner("O007", "Nguyen Thi Lan", parseDate("30/09/1988"), "lannguyen2@gmail.com", "0935123456", "007303004567");
        Owner o8 = new Owner("O008", "Vu Minh Quang", parseDate("02/08/1991"), "quangvu@gmail.com", "0987345678", "008303004567");
        Owner o9 = new Owner("O009", "Dang Thi Bao", parseDate("17/06/1994"), "baodang@gmail.com", "0919876543", "009303004567");
        Owner o10 = new Owner("O010", "Bui Thi Lan", parseDate("11/02/1987"), "lanbui@gmail.com", "0923456789", "010303004567");
        Owner o11 = new Owner("O011", "Pham Thi Mai", parseDate("04/05/1993"), "maipham@gmail.com", "0945567890", "011303004567");
        Owner o12 = new Owner("O012", "Truong Thi Lan", parseDate("20/09/1989"), "lantruong@gmail.com", "0938765432", "012303004567");
        Owner o13 = new Owner("O013", "Nguyen Thi Bao", parseDate("09/10/1996"), "baonguyen@gmail.com", "0972345678", "013303004567");
        Owner o14 = new Owner("O014", "Le Minh Tuan", parseDate("23/07/1983"), "tuanle@gmail.com", "0901234567", "014303004567");
        Owner o15 = new Owner("O015", "Phan Thi Lan", parseDate("13/03/1984"), "lanphan@gmail.com", "0987654321", "015303004567");

        // Hosts
        Host h1 = new Host("H001", "Bui Thu Thao", parseDate("21/01/2005"), "thaobui@gmail.com", "0912345678", "015303004568");
        Host h2 = new Host("H002", "Tran Van Minh", parseDate("15/06/1980"), "minhtran@gmail.com", "0934567891", "015303004569");
        Host h3 = new Host("H003", "Le Thi Kim", parseDate("30/03/1992"), "kimle@gmail.com", "0923456789", "015303004570");
        Host h4 = new Host("H004", "Hoang Minh Duc", parseDate("10/11/1985"), "duchoang@gmail.com", "0909876543", "015303004571");
        Host h5 = new Host("H005", "Nguyen Thuy Linh", parseDate("27/04/1988"), "linhnguyen@gmail.com", "0943216785", "015303004572");
        Host h6 = new Host("H006", "Pham Quoc Bao", parseDate("12/08/1993"), "baoquoc@gmail.com", "0936547892", "015303004573");
        Host h7 = new Host("H007", "Vo Thi Lan", parseDate("18/09/1979"), "lanvo@gmail.com", "0918734569", "015303004574");
        Host h8 = new Host("H008", "Do Thanh Tung", parseDate("23/02/1991"), "tungdo@gmail.com", "0921365478", "015303004575");
        Host h9 = new Host("H009", "Ngo Thi Anh", parseDate("31/05/1982"), "anhngo@gmail.com", "0932178945", "015303004576");
        Host h10 = new Host("H010", "Nguyen Van Hai", parseDate("09/07/1987"), "hainv@gmail.com", "0912765439", "015303004577");
        Host h11 = new Host("H011", "Pham Thi Tuyet", parseDate("05/10/1984"), "tuyetpham@gmail.com", "0905678921", "015303004578");
        Host h12 = new Host("H012", "Dang Minh Khoa", parseDate("16/12/1995"), "khoadang@gmail.com", "0921345679", "015303004579");
        Host h13 = new Host("H013", "Le Van Hoang", parseDate("02/03/1990"), "hoangle@gmail.com", "0912987654", "015303004580");
        Host h14 = new Host("H014", "Nguyen Thi Dung", parseDate("29/09/1996"), "dungnguyen@gmail.com", "0947654321", "015303004581");
        Host h15 = new Host("H015", "Tran Quoc Khanh", parseDate("17/06/1994"), "khanhtran@gmail.com", "0934567890", "015303004582");

        // Tenants
        Tenant t1 = new Tenant("T001", "Chu Duc Duong", parseDate("21/01/2005"), "ducduong@gmail.com", "0912335678", "015203004568");
        Tenant t2 = new Tenant("T002", "Nguyen Van Binh", parseDate("12/02/1992"), "binhnguyen@gmail.com", "0923451234", "015203004569");
        Tenant t3 = new Tenant("T003", "Le Thi Huong", parseDate("04/07/1993"), "huongle@gmail.com", "0932314567", "015203004570");
        Tenant t4 = new Tenant("T004", "Pham Van Thinh", parseDate("10/09/1989"), "thinhpham@gmail.com", "0919876543", "015203004571");
        Tenant t5 = new Tenant("T005", "Vu Thi Lan", parseDate("22/11/1985"), "lanvu@gmail.com", "0945678921", "015203004572");
        Tenant t6 = new Tenant("T006", "Tran Thi Lien", parseDate("15/03/1996"), "lientran@gmail.com", "0921347895", "015203004573");
        Tenant t7 = new Tenant("T007", "Do Van Khanh", parseDate("27/05/1984"), "khanhdo@gmail.com", "0934578912", "015203004574");
        Tenant t8 = new Tenant("T008", "Ngo Thanh Phuc", parseDate("19/08/1991"), "phucngo@gmail.com", "0913456789", "015203004575");
        Tenant t9 = new Tenant("T009", "Pham Quang Hieu", parseDate("29/12/1987"), "hieupham@gmail.com", "0928765431", "015203004576");
        Tenant t10 = new Tenant("T010", "Vo Thi Cam", parseDate("09/04/1982"), "camvo@gmail.com", "0945678901", "015203004577");
        Tenant t11 = new Tenant("T011", "Nguyen Thi Dao", parseDate("11/01/1993"), "daonguyen@gmail.com", "0934125678", "015203004578");
        Tenant t12 = new Tenant("T012", "Hoang Ngoc Son", parseDate("24/06/1985"), "sonhoang@gmail.com", "0912897654", "015203004579");
        Tenant t13 = new Tenant("T013", "Bui Thi Hoa", parseDate("13/10/1990"), "hoabui@gmail.com", "0902345678", "015203004580");
        Tenant t14 = new Tenant("T014", "Le Thanh Lam", parseDate("06/03/1997"), "lamle@gmail.com", "0921456789", "015203004581");
        Tenant t15 = new Tenant("T015", "Nguyen Van An", parseDate("28/08/1994"), "annguyen@gmail.com", "0936789012", "015203004582");

        // Residential Properties:

        //


        // Add objects to list:

        // Run system:
        RentalManagerImplementation2 system = new RentalManagerImplementation2();
        Scanner sc = new Scanner(System.in);
        int operationChoice = -1;
        do {
            clearConsole();

            // Display Menu:
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
            System.out.println("0. Exit");

            // Prompt the user input:
            System.out.print("Enter your choice: ");
            try {
                operationChoice = sc.nextInt();
            } catch (InputMismatchException e) {
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
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        } while (operationChoice != 0);

        sc.close();
    }
}
