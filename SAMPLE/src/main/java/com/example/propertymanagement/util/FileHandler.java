package main.java.com.example.propertymanagement.util;

import main.java.com.example.propertymanagement.entity.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Your Name - Your Student ID
 */
public class FileHandler {
    private static final String DATA_DIRECTORY = "data/";
    private static final String TENANTS_FILE = DATA_DIRECTORY + "tenants.dat";
    private static final String HOSTS_FILE = DATA_DIRECTORY + "hosts.dat";
    private static final String OWNERS_FILE = DATA_DIRECTORY + "owners.dat";
    private static final String PROPERTIES_FILE = DATA_DIRECTORY + "properties.dat";
    private static final String RENTAL_AGREEMENTS_FILE = DATA_DIRECTORY + "rental_agreements.dat";
    private static final String PAYMENTS_FILE = DATA_DIRECTORY + "payments.dat";

    public FileHandler() {
        createDataDirectoryIfNotExists();
    }

    private void createDataDirectoryIfNotExists() {
        File directory = new File(DATA_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void saveTenants(List<Tenant> tenants) {
        saveToFile(tenants, TENANTS_FILE);
    }

    public void saveHosts(List<Host> hosts) {
        saveToFile(hosts, HOSTS_FILE);
    }

    public void saveOwners(List<Owner> owners) {
        saveToFile(owners, OWNERS_FILE);
    }

    public void saveProperties(List<Property> properties) {
        saveToFile(properties, PROPERTIES_FILE);
    }

    public void saveRentalAgreements(List<RentalAgreement> agreements) {
        saveToFile(agreements, RENTAL_AGREEMENTS_FILE);
    }

    public void savePayments(List<Payment> payments) {
        saveToFile(payments, PAYMENTS_FILE);
    }

    public List<Tenant> loadTenants() {
        return loadFromFile(TENANTS_FILE);
    }

    public List<Host> loadHosts() {
        return loadFromFile(HOSTS_FILE);
    }

    public List<Owner> loadOwners() {
        return loadFromFile(OWNERS_FILE);
    }

    public List<Property> loadProperties() {
        return loadFromFile(PROPERTIES_FILE);
    }

    public List<RentalAgreement> loadRentalAgreements() {
        return loadFromFile(RENTAL_AGREEMENTS_FILE);
    }

    public List<Payment> loadPayments() {
        return loadFromFile(PAYMENTS_FILE);
    }

    private <T> void saveToFile(List<T> objects, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(objects);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + filename);
            e.printStackTrace();
        }
    }

    private <T> List<T> loadFromFile(String filename) {
        List<T> objects = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            return objects;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            objects = (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading from file: " + filename);
            e.printStackTrace();
        }

        return objects;
    }
}
