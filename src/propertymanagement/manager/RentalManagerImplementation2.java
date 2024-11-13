package propertymanagement.manager;

import propertymanagement.entity.*;


import java.util.ArrayList;
import java.util.List;

public class RentalManagerImplementation2 implements RentalManager {
    private List<Tenant> tenants;
    private List<Host> hosts;
    private List<Owner> owners;
    private List<Property> properties;
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;


    public RentalManagerImplementation2() {
        this.tenants = new ArrayList<>();
        this.hosts = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.rentalAgreements = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    // Methods to add entities to the system list
    @Override
    public boolean addTenant(Tenant tenant) {
        if (!this.tenants.contains(tenant)) {
            this.tenants.add(tenant);
            return true;
        }
        return false;
    }

    @Override
    public boolean addHost(Host host) {
        if (!this.hosts.contains(host)) {
            this.hosts.add(host);
            return true;
        }
        return false;
    }

    @Override
    public boolean addOwner(Owner owner) {
        if (!this.owners.contains(owner)) {
            this.owners.add(owner);
            return true;
        }
        return false;
    }

    @Override
    public boolean addProperty(Property property) {
        if (!this.properties.contains(property)) {
            this.properties.add(property);
            return true;
        }
        return false;
    }

    @Override
    public boolean addRentalAgreement(RentalAgreement agreement) {
        if (!this.rentalAgreements.contains(agreement)) {
            this.rentalAgreements.add(agreement);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPayment(Payment payment) {
        if (!this.payments.contains(payment)) {
            this.payments.add(payment);
            return true;
        }
        return false;
    }

    // Methods to get entities by id:
    @Override
    public Tenant getTenantById(String id) {
        for (Tenant tenant : this.tenants) {
            if (tenant.getId().equals(id)) {
                return tenant;
            }
        }
        return null;
    }

    @Override
    public Host getHostById(String id) {
        for (Host host : this.hosts) {
            if (host.getId().equals(id)) {
                return host;
            }
        }
        return null;
    }

    @Override
    public Owner getOwnerById(String id) {
        for (Owner owner : this.owners) {
            if (owner.getId().equals(id)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public Property getPropertyById(String id) {
        for (Property property : this.properties) {
            if (property.getId().equals(id)) {
                return property;
            }
        }
        return null;
    }

    @Override
    public RentalAgreement getRentalAgreementById(String id) {
        for (RentalAgreement agreement : this.rentalAgreements) {
            if (agreement.getId().equals(id)) {
                return agreement;
            }
        }
        return null;
    }

    @Override
    public Payment getPaymentById(String id) {
        for (Payment payment : this.payments) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    // Method to get the list of all entities:
    @Override
    public List<Tenant> getAllTenants() {
        return this.tenants;
    }

    @Override
    public List<Host> getAllHosts() {
        return this.hosts;
    }

    @Override
    public List<Owner> getAllOwners() {
        return this.owners;
    }

    @Override
    public List<Property> getAllProperties() {
        return this.properties;
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreements() {
        return this.rentalAgreements;
    }

    @Override
    public List<Payment> getAllPayments() {
        return this.payments;
    }

    // Methods to update entities information
    @Override
    public boolean updateTenant(Tenant tenant) {
        return false;
    }

    @Override
    public boolean updateHost(Host host) {
        return false;
    }

    @Override
    public boolean updateOwner(Owner owner) {
        return false;
    }

    @Override
    public boolean updateProperty(Property property) {
        return false;
    }

    @Override
    public boolean updateRentalAgreement(RentalAgreement agreement) {
        return false;
    }

    @Override
    public boolean updatePayment(Payment payment) {
        return false;
    }

    // Methods to remove entities:
    @Override
    public boolean removeTenant(String id) {
        return false;
    }

    @Override
    public boolean removeHost(String id) {
        return false;
    }

    @Override
    public boolean removeOwner(String id) {
        return false;
    }

    @Override
    public boolean removeProperty(String id) {
        return false;
    }

    @Override
    public boolean removeRentalAgreement(String id) {
        return false;
    }

    @Override
    public boolean removePayment(String id) {
        return false;
    }
}
