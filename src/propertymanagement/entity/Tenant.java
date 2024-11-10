package propertymanagement.entity;

import java.util.Date;
import java.util.List;

public class Tenant extends Person {
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;

    public Tenant(String id, String fullName, Date dateOfBirth, String email, String phoneNumber, String idNumber, List<Payment> payments, List<RentalAgreement> rentalAgreements) {
        super(id, fullName, dateOfBirth, email, phoneNumber, idNumber);
        this.payments = payments;
        this.rentalAgreements = rentalAgreements;
    }
}
