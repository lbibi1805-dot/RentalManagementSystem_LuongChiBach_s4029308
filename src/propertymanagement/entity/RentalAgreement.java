package propertymanagement.entity;

import java.util.Date;

public class RentalAgreement {
    private String id;
    private Property property;
    private Tenant tenant;
    private Host host;
    private Date startDate;
    private Date endDate;
    private double monthlyRent;
    private boolean isActive;


}
