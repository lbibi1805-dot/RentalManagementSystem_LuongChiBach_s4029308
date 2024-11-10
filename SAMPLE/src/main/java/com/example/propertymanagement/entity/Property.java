package main.java.com.example.propertymanagement.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Your Name - Your Student ID
 */
public class Property {
    public enum Status {
        AVAILABLE, RENTED, MAINTENANCE
    }

    private String id;
    private String address;
    private Status status;
    private Owner owner;
    private List<Host> managers;

    public Property(String id, String address, Status status, Owner owner) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.owner = owner;
        this.managers = new ArrayList<>();
    }

    public void addManager(Host manager) {
        if (!managers.contains(manager)) {
            managers.add(manager);
        }
    }

    public void removeManager(Host manager) {
        managers.remove(manager);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Host> getManagers() {
        return new ArrayList<>(managers);
    }

    public void setManagers(List<Host> managers) {
        this.managers = new ArrayList<>(managers);
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", owner=" + owner.getFullName() +
                ", managers=" + managers.size() +
                '}';
    }
}
