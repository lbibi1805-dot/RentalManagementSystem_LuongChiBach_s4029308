package propertymanagement.resources;

import propertymanagement.entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private List<Tenant> tenants = new ArrayList<>();
    private List<Host> hosts = new ArrayList<>();
    private List<Owner> owners = new ArrayList<>();
    private List<Property> properties = new ArrayList<>();
    private List<RentalAgreement> rentalAgreements = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private String path = "src/propertymanagement/resources/";

    // ID tracking maps
    private static final Map<Class<?>, Integer> idCounters = new HashMap<>();
    private static final Map<Class<?>, Map<Integer, Integer>> uniqueIdMaps = new HashMap<>();

    static {
        // Initialize counters and ID maps only for required entity types
        idCounters.put(Owner.class, 1000);
        idCounters.put(Tenant.class, 2000);
        idCounters.put(Host.class, 3000);
        idCounters.put(CommercialProperty.class, 4000);
        idCounters.put(ResidentialProperty.class, 5000);
        idCounters.put(RentalAgreement.class, 6000);
        idCounters.put(Payment.class, 7000);

        uniqueIdMaps.put(Owner.class, new HashMap<>());
        uniqueIdMaps.put(Tenant.class, new HashMap<>());
        uniqueIdMaps.put(Host.class, new HashMap<>());
        uniqueIdMaps.put(CommercialProperty.class, new HashMap<>());
        uniqueIdMaps.put(ResidentialProperty.class, new HashMap<>());
        uniqueIdMaps.put(RentalAgreement.class, new HashMap<>());
        uniqueIdMaps.put(Payment.class, new HashMap<>());
    }


    // Method to save object list to file
    public void writeObjectListToFile(List<Object> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        // Determine the file based on the object type
        String fileName = null;
        if (list.get(0) instanceof Tenant) {
            fileName = "tenants.txt";
        } else if (list.get(0) instanceof Host) {
            fileName = "hosts.txt";
        } else if (list.get(0) instanceof Owner) {
            fileName = "owners.txt";
        } else if (list.get(0) instanceof Property) {
            fileName = "properties.txt";
        } else if (list.get(0) instanceof RentalAgreement) {
            fileName = "rentalAgreements.txt";
        } else if (list.get(0) instanceof Payment) {
            fileName = "payments.txt";
        }

        if (fileName == null) {
            System.out.println("Unknown object type in list.");
            return;
        }

        try (FileOutputStream fileOut = new FileOutputStream(path + fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            // Write the list of objects to the file
            out.writeObject(list);
            System.out.println("Successfully saved " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write objects to file: " + fileName);
        }
    }

    // CURD operations:
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

    public Object getByID(int id) {
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

    public <T> List<T> getAll(Class<T> c) {
        if (c.equals(Tenant.class)) {
            return (List<T>) tenants;
        } else if (c.equals(Host.class)) {
            return (List<T>) hosts;
        } else if (c.equals(Owner.class)) {
            return (List<T>) owners;
        } else if (c.equals(Property.class)) {
            return (List<T>) properties;
        } else if (c.equals(RentalAgreement.class)) {
            return (List<T>) rentalAgreements;
        } else if (c.equals(Payment.class)) {
            return (List<T>) payments;
        }
        return null;
    }

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

    public static int IDGenerator(Class<?> c) {
        if (!idCounters.containsKey(c)) {
            throw new IllegalArgumentException("Unsupported class type for ID generation.");
        }

        int ID;

        do {
            // Generate the next ID for the specific class
            ID = idCounters.get(c);
            idCounters.put(c, ID + 1); // Increment counter for the next call
        } while (uniqueIdMaps.get(c).containsKey(ID)); // Ensure ID is unique

        // Store the generated ID to prevent future duplicates
        uniqueIdMaps.get(c).put(ID, 1);
        return ID;
    }
}