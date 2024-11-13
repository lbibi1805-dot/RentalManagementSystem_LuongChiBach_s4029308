package propertymanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Property {
    public enum Status {
        AVAILABLE, RENTED, MAINTENANCE
    }

    private int id;
    private String address;
    private Status status;
    private Owner owner;
    private List<Host> managers;

    public Property(int id, String address, Status status) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.owner = null;
        this.managers = new ArrayList<>();
    }

    // Methods to add and remove managers:
    public void addManager(Host manager) {
        if (!managers.contains(manager)) managers.add(manager);
    }
    public void removeManager(Host manager) {
        managers.remove(manager);
    }

    // Getters and Setters:
    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public Status getStatus() {
        return status;
    }
    public Owner getOwner() {
        return owner;
    }
    public List<Host> getManagers() {
        return new ArrayList<>(managers);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
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
