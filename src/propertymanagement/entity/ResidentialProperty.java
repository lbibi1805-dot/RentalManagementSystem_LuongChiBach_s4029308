package propertymanagement.entity;

public class ResidentialProperty extends Property{
    private int bedrooms;
    private boolean hasGarden;
    private boolean allowsPets;
    private double area;
    private boolean isRented;

    // Constructors:
    public ResidentialProperty(String id, String address, Status status, Owner owner, int bedrooms, boolean hasGarden, boolean allowsPets, double area) {
        super(id, address, status, owner);
        this.bedrooms = bedrooms;
        this.hasGarden = hasGarden;
        this.allowsPets = allowsPets;
        this.area = area;
        this.isRented = false;
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
    public boolean isRented() {
        return isRented;
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
    public void setRented(boolean rented) {
        isRented = rented;
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
                ", area=" + area +
                ", isRented=" + isRented +
                '}';
    }
}
