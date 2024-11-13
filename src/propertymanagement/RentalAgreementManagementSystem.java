package propertymanagement;

import propertymanagement.entity.Owner;
import propertymanagement.manager.OwnerManager;
import propertymanagement.manager.RentalAgreementManager;
import propertymanagement.resources.Database;
import propertymanagement.util.Formatter;
import propertymanagement.util.UIHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

import static propertymanagement.util.UIHelper.parseDate;

public class RentalAgreementManagementSystem {
    public static void main(String[] args) {
        Database db = new Database();
        OwnerManager om = new OwnerManager(db);
        om.add();
        om.add();
        om.displayAll();
        om.update();
        om.displayAll();
    }

}
