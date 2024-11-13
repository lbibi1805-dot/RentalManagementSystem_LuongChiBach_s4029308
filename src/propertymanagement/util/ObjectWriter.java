package propertymanagement.util;

import propertymanagement.entity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static propertymanagement.util.Formatter.parseDate;

public class ObjectWriter {
    public static void main(String[] args){
        UIHelper uiHelper = new UIHelper();
        try {
            // Initializes files:
            File OwnerFile = new File("src/propertymanagement/resources/Owner.txt");
            File HostFile = new File("src/propertymanagement/resources/Host.txt");
            File PaymentFile = new File("src/propertymanagement/resources/Payment.txt");
            File CommercialPropertyFile = new File("src/propertymanagement/resources/CommercialProperty.txt");
            File ResidentialPropertyFile = new File("src/propertymanagement/resources/ResidentialProperty.txt");
            File TenantFile = new File("src/propertymanagement/resources/Tenant.txt");
            File RentalAgreementFile = new File("src/propertymanagement/resources/RentalAgreement.txt");

            // Create Output Stream For Each File:
            OutputStream Owner = new FileOutputStream(OwnerFile);
            OutputStream Host = new FileOutputStream(HostFile);
            OutputStream Payment = new FileOutputStream(PaymentFile);
            OutputStream CommercialProperty = new FileOutputStream(CommercialPropertyFile);
            OutputStream ResidentialProperty = new FileOutputStream(ResidentialPropertyFile);
            OutputStream Tenant = new FileOutputStream(TenantFile);
            OutputStream RentalAgreement = new FileOutputStream(RentalAgreementFile);

        } catch (Exception e){}

    }


}
