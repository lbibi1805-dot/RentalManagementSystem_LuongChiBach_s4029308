package main.java.com.example.propertymanagement.entity;

import java.util.Date;

/**
 * @author Your Name - Your Student ID
 */
public class Payment {
    private String id;
    private RentalAgreement rentalAgreement;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;

    public Payment(String id, RentalAgreement rentalAgreement, double amount, Date paymentDate, String paymentMethod) {
        this.id = id;
        this.rentalAgreement = rentalAgreement;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RentalAgreement getRentalAgreement() {
        return rentalAgreement;
    }

    public void setRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreement = rentalAgreement;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", rentalAgreement=" + rentalAgreement.getId() +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
