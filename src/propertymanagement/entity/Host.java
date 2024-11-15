package propertymanagement.entity;

import propertymanagement.resources.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Host extends Person implements Serializable {
    private List<Property> managedProperties;
    private List<RentalAgreement> rentalAgreements;
    private List<Owner> associatedOwners;

    // Constructors:
    public Host(int id, String fullName, Date dateOfBirth, String email, String phoneNumber) {
        super(id, fullName, dateOfBirth, email, phoneNumber);
        this.managedProperties = new ArrayList<>();
        this.rentalAgreements = new ArrayList<>();
        this.associatedOwners = new ArrayList<>();
    }


    // Methods to add to Lists:
    public void addManagedProperty(Property property) {
        if (!managedProperties.contains(property)) managedProperties.add(property);
    }

    public void addRentalAgreement(RentalAgreement agreement) {
        if (!rentalAgreements.contains(agreement)) rentalAgreements.add(agreement);
    }

    public void addAssociatedOwner(Owner owner) {
        if (!associatedOwners.contains(owner)) associatedOwners.add(owner);
    }

    // Methods to remove from Lists:
    public void removeManagedProperty(Property property) {
        managedProperties.remove(property);
    }

    public void removeRentalAgreement(RentalAgreement agreement) {
        rentalAgreements.remove(agreement);
    }

    public void removeAssociatedOwner(Owner owner) {
        associatedOwners.remove(owner);
    }

    // Getters and Setters:
    public List<Property> getManagedProperties() {
        return new ArrayList<>(managedProperties);
    }
    public void setManagedProperties(List<Property> managedProperties) {
        this.managedProperties = new ArrayList<>(managedProperties);
    }

    public List<RentalAgreement> getRentalAgreements() {
        return new ArrayList<>(rentalAgreements);
    }
    public void setRentalAgreements(List<RentalAgreement> rentalAgreements) {
        this.rentalAgreements = new ArrayList<>(rentalAgreements);
    }

    public List<Owner> getAssociatedOwners() {
        return new ArrayList<>(associatedOwners);
    }
    public void setAssociatedOwners(List<Owner> associatedOwners) {
        this.associatedOwners = new ArrayList<>(associatedOwners);
    }

    @Override
    public String toString() {
        return "Host{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", managedProperties=" + managedProperties.size() +
                ", rentalAgreements=" + rentalAgreements.size() +
                ", associatedOwners=" + associatedOwners.size() +
                '}';
    }
}
