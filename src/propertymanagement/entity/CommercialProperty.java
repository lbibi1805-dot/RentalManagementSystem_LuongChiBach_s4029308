package propertymanagement.entity;

public class CommercialProperty extends Property{
    private String businessType;
    private boolean hasParking;
    private double floorArea;

    // Constructors:
    public CommercialProperty(int id, String address, Status status, Owner owner, String businessType, boolean hasParking, double floorArea) {
        super(id, address, status, owner);
        this.businessType = businessType;
        this.hasParking = hasParking;
        this.floorArea = floorArea;
    }

    // Getters and Setters:
    public String getBusinessType() {
        return businessType;
    }
    public double getFloorArea() {
        return floorArea;
    }
    public boolean isHasParking() {
        return hasParking;
    }

    public void setFloorArea(double floorArea) {
        this.floorArea = floorArea;
    }
    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
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
