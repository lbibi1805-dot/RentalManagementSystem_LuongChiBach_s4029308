package propertymanagement.entity;

public class ResidentialProperty extends Property{
    private int bedrooms;
    private boolean hasGarden;
    private boolean allowsPets;
    private double area;

    // Constructors:
    public ResidentialProperty(int id, String address, Status status, int bedrooms, boolean hasGarden, boolean allowsPets, double area) {
        super(id, address, status);
        this.bedrooms = bedrooms;
        this.hasGarden = hasGarden;
        this.allowsPets = allowsPets;
        this.area = area;
    }

    // Setter and Getters:
    public int getBedrooms() {
        return bedrooms;
    }
    public boolean isHasGarden() {
        return hasGarden;
    }
    public boolean isAllowsPets() {
        return allowsPets;
    }
    public double getArea() {
        return area;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }
    public void setAllowsPets(boolean allowsPets) {
        this.allowsPets = allowsPets;
    }
    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "ResidentialProperty{" +
                "id='" + getId() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", status=" + getStatus() +
                ", owner=" + getOwner().getFullName() +
                ", bedrooms=" + bedrooms +
                ", hasGarden=" + hasGarden +
                ", allowsPets=" + allowsPets +
                ", area=" + area;
    }
}
