package propertymanagement.manager;

import main.java.com.example.propertymanagement.entity.*;

import java.util.ArrayList;
import java.util.List;

public class RentalAgreementManagerImplementation implements RentalAgreementManager {
    private List<Tenant> tenants;
    private List<Host> hosts;
    private List<Owner> owners;
    private List<Property> properties;
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> payments;

//    private FileHandler fileHandler;


    public RentalAgreementManagerImplementation() {
        this.tenants = new ArrayList<>();
        this.hosts = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.rentalAgreements = new ArrayList<>();
        this.payments = new ArrayList<>();
//        this.fileHandler = new FileHandler();
//        loadData();
    }

    @Override
    public boolean add(Object o) {
        if (o instanceof Tenant tenant && !tenants.contains(tenant)) {
            tenants.add(tenant);
            return true;
        } else if (o instanceof Host host && !hosts.contains(host)) {
            hosts.add(host);
            return true;
        } else if (o instanceof Owner owner && !owners.contains(owner)) {
            owners.add(owner);
            return true;
        } else if (o instanceof Property property && !properties.contains(property)) {
            properties.add(property);
            return true;
        } else if (o instanceof RentalAgreement agreement && !rentalAgreements.contains(agreement)) {
            rentalAgreements.add(agreement);
            return true;
        } else if (o instanceof Payment payment && !payments.contains(payment)) {
            payments.add(payment);
            return true;
        }
        return false;
    }

    @Override
    public Object getByID(String id) {
        for (Tenant tenant : tenants) {
            if (tenant.getId() == id) return tenant;
        }
        for (Host host : hosts) {
            if (host.getId() == id) return host;
        }
        for (Owner owner : owners) {
            if (owner.getId() == id) return owner;
        }
        for (Property property : properties) {
            if (property.getId() == id) return property;
        }
        for (RentalAgreement agreement : rentalAgreements) {
            if (agreement.getId() == id) return agreement;
        }
        for (Payment payment : payments) {
            if (payment.getId() == id) return payment;
        }
        return null;
    }

    @Override
    public List<Object> getAll() {
        List<Object> allEntities = new ArrayList<>();
        Object o = new Object();

        if (o instanceof Tenant) allEntities.addAll(tenants);
        if (o instanceof Host) allEntities.addAll(hosts);
        if (o instanceof Owner)allEntities.addAll(owners);
        if (o instanceof Property) allEntities.addAll(properties);
        if (o instanceof RentalAgreement) allEntities.addAll(rentalAgreements);
        if (o instanceof Payment) allEntities.addAll(payments);

        return allEntities;
    }

    @Override
    public void update(Object o) {
        if (o instanceof Tenant tenant) {
            tenants.removeIf(t -> t.getId() == tenant.getId());
            tenants.add(tenant);
        } else if (o instanceof Host host) {
            hosts.removeIf(h -> h.getId() == host.getId());
            hosts.add(host);
        } else if (o instanceof Owner owner) {
            owners.removeIf(m -> m.getId() == owner.getId());
            owners.add(owner);
        } else if (o instanceof Property property) {
            properties.removeIf(p -> p.getId() == property.getId());
            properties.add(property);
        } else if (o instanceof RentalAgreement agreement) {
            rentalAgreements.removeIf(ra -> ra.getId() == agreement.getId());
            rentalAgreements.add(agreement);
        } else if (o instanceof Payment payment) {
            payments.removeIf(p -> p.getId() == payment.getId());
            payments.add(payment);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Tenant tenant) {
            return tenants.remove(tenant);
        } else if (o instanceof Host host) {
            return hosts.remove(host);
        } else if (o instanceof Owner owner) {
            return owners.remove(owner);
        } else if (o instanceof Property property) {
            return properties.remove(property);
        } else if (o instanceof RentalAgreement agreement) {
            return rentalAgreements.remove(agreement);
        } else if (o instanceof Payment payment) {
            return payments.remove(payment);
        }
        return false;
    }

    // Custom Methods:
    @Override
    public List<?> getExpiredRentalAgreements() {
        return List.of();
    }

    
}
