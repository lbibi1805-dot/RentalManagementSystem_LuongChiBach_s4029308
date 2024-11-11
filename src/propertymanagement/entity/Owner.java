package propertymanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Owner extends Person{
    private List<Property> ownedProperties;

    // Constructors:
    public Owner(String id, String fullName, Date dateOfBirth, String email, String phoneNumber, String idNumber) {
        super(id, fullName, dateOfBirth, email, phoneNumber, idNumber);
        this.ownedProperties = new ArrayList<>();
    }

    // Methods to add or remove Property for the Owner:
    public void addOwnedProperty(Property property) {
        if (!ownedProperties.contains(property)) ownedProperties.add(property);
    }
    public void removeOwnedProperty(Property property) {
        ownedProperties.remove(property);
    }

    // Getters and Setters:
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
