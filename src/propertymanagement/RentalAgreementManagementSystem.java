package propertymanagement;

import propertymanagement.manager.OwnerManager;
import propertymanagement.manager.ResidentialPropertyManagement;
import propertymanagement.resources.Database;

public class RentalAgreementManagementSystem {
    public static void main(String[] args) {
        Database db = new Database();
        OwnerManager om = new OwnerManager(db);
        ResidentialPropertyManagement rs = new ResidentialPropertyManagement(db);

        // Testing Owner Management:
//        om.add();
//        om.add();
//        om.displayAll();
//        om.update();
//        om.displayAll();

        // Testing Residential Property:
        rs.add();
        rs.add();
        rs.displayAll();
        rs.update();
        rs.displayAll();
    }

}
