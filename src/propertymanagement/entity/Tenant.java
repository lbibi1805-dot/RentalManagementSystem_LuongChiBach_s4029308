package propertymanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant extends Person {
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;

    public Tenant(int id, String fullName, Date dateOfBirth, String email, String phoneNumber, String idNumber) {
        super(id, fullName, dateOfBirth, email, phoneNumber, idNumber);
        this.rentalAgreements = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    // Methods to add or remove:
    public void addRentalAgreement(RentalAgreement agreement) {
        if (!rentalAgreements.contains(agreement)) rentalAgreements.add(agreement);
    }
    public void addPayment(Payment payment) {
        if (!payments.contains(payment)) {
            payments.add(payment);
        }
    }

    public void removeRentalAgreement(RentalAgreement agreement) {
        rentalAgreements.remove(agreement);
    }
    public void removePayment(Payment payment) {
        payments.remove(payment);
    }

    // Getters and Setters:
    public List<RentalAgreement> getRentalAgreements() {
        return new ArrayList<>(rentalAgreements);
    }
    public List<Payment> getPayments() {
        return new ArrayList<>(payments);
    }

    public void setRentalAgreements(List<RentalAgreement> rentalAgreements) {
        this.rentalAgreements = new ArrayList<>(rentalAgreements);
    }
    public void setPayments(List<Payment> payments) {
        this.payments = new ArrayList<>(payments);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", idNumber='" + getIdNumber() + '\'' +
                ", rentalAgreements=" + rentalAgreements.size() +
                ", payments=" + payments.size() +
                '}';
    }
}
