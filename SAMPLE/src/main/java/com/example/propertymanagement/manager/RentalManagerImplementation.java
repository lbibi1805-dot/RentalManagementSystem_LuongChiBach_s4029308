package main.java.com.example.propertymanagement.manager;

import main.java.com.example.propertymanagement.entity.*;
import main.java.com.example.propertymanagement.util.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Your Name - Your Student ID
 */
public class RentalManagerImplementation implements RentalManager {
    private List<Tenant> tenants;
    private List<Host> hosts;
    private List<Owner> owners;
    private List<Property> properties;
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;

    private FileHandler fileHandler;

    public RentalManagerImplementation() {
        this.tenants = new ArrayList<>();
        this.hosts = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.rentalAgreements = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.fileHandler = new FileHandler();
        loadData();
    }

    private void loadData() {
        tenants = fileHandler.loadTenants();
        hosts = fileHandler.loadHosts();
        owners = fileHandler.loadOwners();
        properties = fileHandler.loadProperties();
        rentalAgreements = fileHandler.loadRentalAgreements();
        payments = fileHandler.loadPayments();
    }

    private void saveData() {
        fileHandler.saveTenants(tenants);
        fileHandler.saveHosts(hosts);
        fileHandler.saveOwners(owners);
        fileHandler.saveProperties(properties);
        fileHandler.saveRentalAgreements(rentalAgreements);
        fileHandler.savePayments(payments);
    }

    @Override
    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
        saveData();
    }

    @Override
    public void addHost(Host host) {
        hosts.add(host);
        saveData();
    }

    @Override
    public void addOwner(Owner owner) {
        owners.add(owner);
        saveData();
    }

    @Override
    public void addProperty(Property property) {
        properties.add(property);
        saveData();
    }

    @Override
    public void addRentalAgreement(RentalAgreement agreement) {
        rentalAgreements.add(agreement);
        saveData();
    }

    @Override
    public void addPayment(Payment payment) {
        payments.add(payment);
        saveData();
    }

    @Override
    public Tenant getTenantById(String id) {
        return tenants.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Host getHostById(String id) {
        return hosts.stream().filter(h -> h.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Owner getOwnerById(String id) {
        return owners.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Property getPropertyById(String id) {
        return properties.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public RentalAgreement getRentalAgreementById(String id) {
        return rentalAgreements.stream().filter(ra -> ra.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Payment getPaymentById(String id) {
        return payments.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return new ArrayList<>(tenants);
    }

    @Override
    public List<Host> getAllHosts() {
        return new ArrayList<>(hosts);
    }

    @Override
    public List<Owner> getAllOwners() {
        return new ArrayList<>(owners);
    }

    @Override
    public List<Property> getAllProperties() {
        return new ArrayList<>(properties);
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreements() {
        return new ArrayList<>(rentalAgreements);
    }

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }

    @Override
    public void updateTenant(Tenant tenant) {
        int index = tenants.indexOf(getTenantById(tenant.getId()));
        if (index != -1) {
            tenants.set(index, tenant);
            saveData();
        }
    }

    @Override
    public void updateHost(Host host) {
        int index = hosts.indexOf(getHostById(host.getId()));
        if (index != -1) {
            hosts.set(index, host);
            saveData();
        }
    }

    @Override
    public void updateOwner(Owner owner) {
        int index = owners.indexOf(getOwnerById(owner.getId()));
        if (index != -1) {
            owners.set(index, owner);
            saveData();
        }
    }

    @Override
    public void updateProperty(Property property) {
        int index = properties.indexOf(getPropertyById(property.getId()));
        if (index != -1) {
            properties.set(index, property);
            saveData();
        }
    }

    @Override
    public void updateRentalAgreement(RentalAgreement agreement) {
        int index = rentalAgreements.indexOf(getRentalAgreementById(agreement.getId()));
        if (index != -1) {
            rentalAgreements.set(index, agreement);
            saveData();
        }
    }

    @Override
    public void updatePayment(Payment payment) {
        int index = payments.indexOf(getPaymentById(payment.getId()));
        if (index != -1) {
            payments.set(index, payment);
            saveData();
        }
    }

    @Override
    public boolean removeTenant(String id) {
        boolean removed = tenants.removeIf(t -> t.getId().equals(id));
        if (removed) {
            saveData();
        }
        return removed;
    }

    @Override
    public boolean removeHost(String id) {
        boolean removed = hosts.removeIf(h -> h.getId().equals(id));
        if (removed) {
            saveData();
        }
        return removed;
    }

    @Override
    public boolean removeOwner(String id) {
        boolean removed = owners.removeIf(o -> o.getId().equals(id));
        if (removed) {
            saveData();
        }
        return removed;
    }

    @Override
    public boolean removeProperty(String id) {
        boolean removed = properties.removeIf(p -> p.getId().equals(id));
        if (removed) {
            saveData();
        }
        return removed;
    }

    @Override
    public boolean removeRentalAgreement(String id) {
        boolean removed = rentalAgreements.removeIf(ra -> ra.getId().equals(id));
        if (removed) {
            saveData();
        }
        return removed;
    }

    @Override
    public boolean removePayment(String id) {
        boolean removed = payments.removeIf(p -> p.getId().equals(id));
        if (removed) {
            saveData();
        }
        return removed;
    }

    @Override
    public List<Property> getAvailableProperties() {
        return properties.stream()
                .filter(p -> p.getStatus() == Property.Status.AVAILABLE)
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalAgreement> getActiveRentalAgreements() {
        return rentalAgreements.stream()
                .filter(RentalAgreement::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> getPaymentsByTenant(String tenantId) {
        return payments.stream()
                .filter(p -> p.getRentalAgreement().getTenant().getId().equals(tenantId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> getPropertiesByOwner(String ownerId) {
        return properties.stream()
                .filter(p -> p.getOwner().getId().equals(ownerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalAgreement> getRentalAgreementsByHost(String hostId) {
        return rentalAgreements.stream()
                .filter(ra -> ra.getHost().getId().equals(hostId))
                .collect(Collectors.toList());
    }
}
