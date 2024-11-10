package main.java.com.example.propertymanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Your Name - Your Student ID
 */
public class Tenant extends Person {
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;

    public Tenant(String id, String fullName, Date dateOfBirth, String email, String phoneNumber, String idNumber) {
        super(id, fullName, dateOfBirth, email, phoneNumber, idNumber);
        this.rentalAgreements = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addRentalAgreement(RentalAgreement agreement) {
        if (!rentalAgreements.contains(agreement)) {
            rentalAgreements.add(agreement);
        }
    }

    public void removeRentalAgreement(RentalAgreement agreement) {
        rentalAgreements.remove(agreement);
    }

    public void addPayment(Payment payment) {
        if (!payments.contains(payment)) {
            payments.add(payment);
        }
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
    }

    public List<RentalAgreement> getRentalAgreements() {
        return new ArrayList<>(rentalAgreements);
    }

    public void setRentalAgreements(List<RentalAgreement> rentalAgreements) {
        this.rentalAgreements = new ArrayList<>(rentalAgreements);
    }

    public List<Payment> getPayments() {
        return new ArrayList<>(payments);
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
