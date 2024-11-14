package propertymanagement.resources;

import propertymanagement.entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private List<Tenant> tenants;
    private List<Host> hosts ;
    private List<Owner> owners ;
    private List<ResidentialProperty> residentialProperties;
    private List<CommercialProperty> commercialProperties ;
    private List<RentalAgreement> rentalAgreements ;
    private List<Payment> payments;

    private String path = "src/propertymanagement/resources/";

    public Database() {
        tenants = new ArrayList<>();
        hosts = new ArrayList<>();
        owners = new ArrayList<>();
        residentialProperties = new ArrayList<>();
        commercialProperties = new ArrayList<>();
        rentalAgreements = new ArrayList<>();
        payments = new ArrayList<>();

         loadData();
    }

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

//    public void loadData(){
//        try{
//            File file = new File(path + "USER_DATA.ser");
//            File file2 = new File(path + "USER_ID.SER");
//
//            if (file.length() == 0 || file2.length() == 0) return;
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
//
//            tenants = (List<Tenant>) in.readObject();
//            hosts = (List<Host>) in.readObject();
//            owners = (List<Owner>) in.readObject();
//            residentialProperties = (List<ResidentialProperty>) in.readObject();
//            commercialProperties = (List<CommercialProperty>) in.readObject();
//            rentalAgreements = (List<RentalAgreement>) in.readObject();
//            payments = (List<Payment>) in.readObject();
//
//            in.close();
//
//            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(file2));
//            PERSON_ID = (Map<Integer, Integer>) in2.readObject();
//            PROPERTY_ID = (Map<Integer, Integer>) in2.readObject();
//            PAYMENT_ID = (Map<Integer, Integer>) in2.readObject();
//            AGREEMENT_ID = (Map<Integer, Integer> ) in2.readObject();
//            in2.close();
//
//            System.out.println("Data loaded successfully");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

//    public void saveData(){
//        try{
//            File file = new File(path + "USER_DATA.ser");
//            ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(file));
//            data.writeObject(hosts);
//            data.writeObject(owners);
//            data.writeObject(tenants);
//            data.writeObject(rentalAgreements);
//            data.writeObject(residentialProperties);
//            data.writeObject(commercialProperties);
//            data.writeObject(payments);
//
//            File file2 = new File(path + "USER_ID.SER");
//            ObjectOutputStream ID = new ObjectOutputStream(new FileOutputStream(file2));
//
//            ID.writeObject(PERSON_ID);
//            ID.writeObject(PROPERTY_ID);
//            ID.writeObject(PAYMENT_ID);
//            ID.writeObject(AGREEMENT_ID);
//            ID.close();
//            ID.flush();
//
//            System.out.println(">>Data saved successfully");
//        } catch (Exception e) System.out.println(e);
//    }






//    @SuppressWarnings("unchecked")
//    public void loadData() {
//        try {
//            File file = new File(path + "USER_DATA.ser");
//            File file2 = new File(path + "USER_ID.SER");
//
//            if (file.length() > 0 && file2.length() > 0) {
//                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//                    tenants = (List<Tenant>) in.readObject();
//                    hosts = (List<Host>) in.readObject();
//                    owners = (List<Owner>) in.readObject();
//                    residentialProperties = (List<ResidentialProperty>) in.readObject();
//                    commercialProperties = (List<CommercialProperty>) in.readObject();
//                    rentalAgreements = (List<RentalAgreement>) in.readObject();
//                    payments = (List<Payment>) in.readObject();
//                }
//
//                try (ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(file2))) {
//                    Map<Class<?>, Integer> loadedCounters = (Map<Class<?>, Integer>) in2.readObject();
//                    idCounters.putAll(loadedCounters);
//
//                    Map<Class<?>, Map<Integer, Integer>> loadedUniqueIds = (Map<Class<?>, Map<Integer, Integer>>) in2.readObject();
//                    uniqueIdMaps.putAll(loadedUniqueIds);
//                }
//
//                System.out.println("Data loaded successfully");
//            }
//        } catch (Exception e) {
//            System.out.println("Error loading data: " + e.getMessage());
//        }
//    }
//
//    public void saveData() {
//        try {
//            File file = new File(path + "USER_DATA.ser");
//            try (ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(file))) {
//                data.writeObject(tenants);
//                data.writeObject(hosts);
//                data.writeObject(owners);
//                data.writeObject(residentialProperties);
//                data.writeObject(commercialProperties);
//                data.writeObject(rentalAgreements);
//                data.writeObject(payments);
//            }
//
//            File file2 = new File(path + "USER_ID.SER");
//            try (ObjectOutputStream idOut = new ObjectOutputStream(new FileOutputStream(file2))) {
//                idOut.writeObject(idCounters);
//                idOut.writeObject(uniqueIdMaps);
//            }
//
//            System.out.println("Data saved successfully");
//        } catch (Exception e) {
//            System.out.println("Error saving data: " + e.getMessage());
//        }
//    }


    public void loadData() {
        try {
            File file = new File(path + "USER_DATA.ser");

            if (file.length() == 0) return;

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            tenants = (List<Tenant>) in.readObject();
            hosts = (List<Host>) in.readObject();
            owners = (List<Owner>) in.readObject();
            residentialProperties = (List<ResidentialProperty>) in.readObject();
            commercialProperties = (List<CommercialProperty>) in.readObject();
            rentalAgreements = (List<RentalAgreement>) in.readObject();
            payments = (List<Payment>) in.readObject();
            in.close();

            System.out.println("Data loaded successfully");

        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Save data to serialized file
    public void saveData() {
        try {
            ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(path + "USER_DATA.ser"));
            data.writeObject(tenants);
            data.writeObject(hosts);
            data.writeObject(owners);
            data.writeObject(residentialProperties);
            data.writeObject(commercialProperties);
            data.writeObject(rentalAgreements);
            data.writeObject(payments);
            data.close();

            System.out.println("Data saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
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
        } else if (o instanceof ResidentialProperty residentialProperty && !residentialProperties.contains(residentialProperty)) {
            residentialProperties.add(residentialProperty);
            return true;
        } else if (o instanceof CommercialProperty commercialProperty && !commercialProperties.contains(commercialProperty)) {
            commercialProperties.add(commercialProperty);
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
            return null;
        }
        for (Host host : hosts) {
            if (host.getId() == id) return host;
            return null;
        }
        for (Owner owner : owners) {
            if (owner.getId() == id) return owner;
            return null;
        }
        for (ResidentialProperty residentialProperty : residentialProperties) {
            if (residentialProperty.getId() == id) return residentialProperty;
            else return null;
        }
        for (CommercialProperty commercialProperty : commercialProperties) {
            if (commercialProperty.getId() == id) return commercialProperty;
            return null;
        }
        for (RentalAgreement agreement : rentalAgreements) {
            if (agreement.getId() == id) return agreement;
            return null;
        }
        for (Payment payment : payments) {
            if (payment.getId() == id) return payment;
            return null;
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
        } else if (c.equals(ResidentialProperty.class)) {
            return (List<T>) residentialProperties;
        } else if (c.equals(CommercialProperty.class)) {
            return (List<T>) commercialProperties;
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
        } else if (o instanceof ResidentialProperty residentialProperty) {
            residentialProperties.removeIf(p -> p.getId() == residentialProperty.getId());
            residentialProperties.add(residentialProperty);
        } else if (o instanceof CommercialProperty commercialProperty) {
            commercialProperties.removeIf(p -> p.getId() == commercialProperty.getId());
            commercialProperties.add(commercialProperty);
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
        } else if (o instanceof ResidentialProperty residentialProperty) {
            return residentialProperties.remove(residentialProperty);
        } else if (o instanceof CommercialProperty commercialProperty) {
            return commercialProperties.remove(commercialProperty);
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
