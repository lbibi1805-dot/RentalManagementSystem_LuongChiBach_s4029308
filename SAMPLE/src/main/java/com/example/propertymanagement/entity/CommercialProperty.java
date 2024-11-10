package main.java.com.example.propertymanagement.entity;

/**
 * @author Your Name - Your Student ID
 */
public class CommercialProperty extends Property {
    private String businessType;
    private boolean hasParking;
    private double floorArea;

    public CommercialProperty(String id, String address, Status status, Owner owner, String businessType, boolean hasParking, double floorArea) {
        super(id, address, status, owner);
        this.businessType = businessType;
        this.hasParking = hasParking;
        this.floorArea = floorArea;
    }

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
                "businessType='" + businessType + '\'' +
                ", hasParking=" + hasParking +
                ", floorArea=" + floorArea +
                '}';
    }
}

