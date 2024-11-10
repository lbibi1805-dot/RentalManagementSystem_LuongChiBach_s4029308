package main.java.com.example.propertymanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Your Name - Your Student ID
 */
public class Owner extends Person {
    private List<Property> ownedProperties;

    public Owner(String id, String fullName, Date dateOfBirth, String email, String phoneNumber, String idNumber) {
        super(id, fullName, dateOfBirth, email, phoneNumber, idNumber);
        this.ownedProperties = new ArrayList<>();
    }

    public void addOwnedProperty(Property property) {
        if (!ownedProperties.contains(property)) {
            ownedProperties.add(property);
        }
    }

    public void removeOwnedProperty(Property property) {
        ownedProperties.remove(property);
    }

    public List<Property> getOwnedProperties() {
        return new ArrayList<>(ownedProperties);
    }

    public void setOwnedProperties(List<Property> ownedProperties) {
        this.ownedProperties = new ArrayList<>(ownedProperties);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + getId() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", idNumber='" + getIdNumber() + '\'' +
                ", ownedProperties=" + ownedProperties.size() +
                '}';
    }
}
