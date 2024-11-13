package propertymanagement.manager;

import propertymanagement.entity.*;

import java.util.List;

public interface RentalManager  {
    // Methods to add Entities:
    boolean addTenant(Tenant tenant);
    boolean addHost(Host host);
    boolean addOwner(Owner owner);
    boolean addProperty(Property property);
    boolean addRentalAgreement(RentalAgreement agreement);
    boolean addPayment(Payment payment);

    // Methods to get Entities by their ID:
    Tenant getTenantById(String id);
    Host getHostById(String id);
    Owner getOwnerById(String id);
    Property getPropertyById(String id);
    RentalAgreement getRentalAgreementById(String id);
    Payment getPaymentById(String id);

    // Methods to get the List of Entities:
    List<Tenant> getAllTenants();
    List<Host> getAllHosts();
    List<Owner> getAllOwners();
    List<Property> getAllProperties();
    List<RentalAgreement> getAllRentalAgreements();
    List<Payment> getAllPayments();

    // Methods to update the Entities:
    boolean updateTenant(Tenant tenant);
    boolean updateHost(Host host);
    boolean updateOwner(Owner owner);
    boolean updateProperty(Property property);
    boolean updateRentalAgreement(RentalAgreement agreement);
    boolean updatePayment(Payment payment);

    // Method to Remove Entities:
    boolean removeTenant(String id);
    boolean removeHost(String id);
    boolean removeOwner(String id);
    boolean removeProperty(String id);
    boolean removeRentalAgreement(String id);
    boolean removePayment(String id);

}
