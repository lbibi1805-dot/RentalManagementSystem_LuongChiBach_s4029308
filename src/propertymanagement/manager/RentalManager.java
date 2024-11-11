package propertymanagement.manager;

import propertymanagement.entity.*;

import java.util.List;

public interface RentalManager  {
    // Methods to add Entities:
    void addTenant(Tenant tenant);
    void addHost(Host host);
    void addOwner(Owner owner);
    void addProperty(Property property);
    void addRentalAgreement(RentalAgreement agreement);
    void addPayment(Payment payment);

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
    void updateTenant(Tenant tenant);
    void updateHost(Host host);
    void updateOwner(Owner owner);
    void updateProperty(Property property);
    void updateRentalAgreement(RentalAgreement agreement);
    void updatePayment(Payment payment);

    // Method to Remove Entities:
    boolean removeTenant(String id);
    boolean removeHost(String id);
    boolean removeOwner(String id);
    boolean removeProperty(String id);
    boolean removeRentalAgreement(String id);
    boolean removePayment(String id);

    // Methods to getEntities by related Entities:
    List<Property> getAvailableProperties();
    List<RentalAgreement> getActiveRentalAgreements();
    List<Payment> getPaymentsByTenant(String tenantId);
    List<Property> getPropertiesByOwner(String ownerId);
    List<RentalAgreement> getRentalAgreementsByHost(String hostId);
}
