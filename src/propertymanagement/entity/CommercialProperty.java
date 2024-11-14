package propertymanagement.entity;

import java.io.Serializable;

public class CommercialProperty extends Property implements Serializable {
    private String businessType;
    private boolean hasParking;
    private double floorArea;

    // Constructors:
    public CommercialProperty(int id, String address, Status status, String businessType, boolean hasParking, double floorArea) {
        super(id, address, status);
        this.businessType = businessType;
        this.hasParking = hasParking;
        this.floorArea = floorArea;
    }

    // Getters and Setters:
    public String getBusinessType() {
        return businessType;
    }
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public boolean isHasParking() {
        return hasParking;
    }
    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public double getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(double floorArea) {
        this.floorArea = floorArea;
    }

    @Override
    public String toString() {
        return "CommercialProperty{" +
                "id = " + getId() +
                ", address = " + getAddress() +
                ", businessType='" + getBusinessType() + '\'' +
                ", status = " + getStatus() +
                ", hasParking=" + isHasParking() +
                ", floorArea=" + getFloorArea() +
                '}';
    }
}
