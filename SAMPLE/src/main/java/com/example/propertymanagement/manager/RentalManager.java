package main.java.com.example.propertymanagement.manager;

import main.java.com.example.propertymanagement.entity.*;
import java.util.List;

public interface RentalManager {
    void addTenant(Tenant tenant);
    void addHost(Host host);
    void addOwner(Owner owner);
    void addProperty(Property property);
    void addRentalAgreement(RentalAgreement agreement);
    void addPayment(Payment payment);

    Tenant getTenantById(String id);
    Host getHostById(String id);
    Owner getOwnerById(String id);
    Property getPropertyById(String id);
    RentalAgreement getRentalAgreementById(String id);
    Payment getPaymentById(String id);

    List<Tenant> getAllTenants();
    List<Host> getAllHosts();
    List<Owner> getAllOwners();
    List<Property> getAllProperties();
    List<RentalAgreement> getAllRentalAgreements();
    List<Payment> getAllPayments();

    void updateTenant(Tenant tenant);
    void updateHost(Host host);
    void updateOwner(Owner owner);
    void updateProperty(Property property);
    void updateRentalAgreement(RentalAgreement agreement);
    void updatePayment(Payment payment);

    boolean removeTenant(String id);
    boolean removeHost(String id);
    boolean removeOwner(String id);
    boolean removeProperty(String id);
    boolean removeRentalAgreement(String id);
    boolean removePayment(String id);

    List<Property> getAvailableProperties();
    List<RentalAgreement> getActiveRentalAgreements();
    List<Payment> getPaymentsByTenant(String tenantId);
    List<Property> getPropertiesByOwner(String ownerId);
    List<RentalAgreement> getRentalAgreementsByHost(String hostId);
}
