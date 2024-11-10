package main.java.com.example.propertymanagement.entity;

import java.util.Date;

/**
 * @author Your Name - Your Student ID
 */
public class RentalAgreement {
    private String id;
    private Property property;
    private Tenant tenant;
    private Host host;
    private Date startDate;
    private Date endDate;
    private double monthlyRent;
    private boolean isActive;

    public RentalAgreement(String id, Property property, Tenant tenant, Host host, Date startDate, Date endDate, double monthlyRent) {
        this.id = id;
        this.property = property;
        this.tenant = tenant;
        this.host = host;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRent = monthlyRent;
        this.isActive = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "RentalAgreement{" +
                "id='" + id + '\'' +
                ", property=" + property.getId() +
                ", tenant=" + tenant.getFullName() +
                ", host=" + host.getFullName() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", monthlyRent=" + monthlyRent +
                ", isActive=" + isActive +
                '}';
    }
}
