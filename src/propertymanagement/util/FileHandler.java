package propertymanagement.util;

import propertymanagement.entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String DATA_DIRECTORY = "E:\\RMIT\\Further_Programming\\Assignment 1\\RentalManagementSystem_LuongChiBach_s4029308\\src\\propertymanagement\\resources\\";
    private static final String TENANTS_FILE = DATA_DIRECTORY + "tenants.dat";
    private static final String HOSTS_FILE = DATA_DIRECTORY + "hosts.txt";
    private static final String OWNERS_FILE = DATA_DIRECTORY + "owners.txt";
    private static final String PROPERTIES_FILE = DATA_DIRECTORY + "properties.txt";
    private static final String RENTAL_AGREEMENTS_FILE = DATA_DIRECTORY + "rental_agreements.txt";
    private static final String PAYMENTS_FILE = DATA_DIRECTORY + "payments.txt";

    // Constructors:
    public FileHandler() {
        createDataDirectoryIfNotExists();
    }

    // Methods for basic operations load, save, create dir:
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
    private void createDataDirectoryIfNotExists() {
        File directory = new File(DATA_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    // Methods for saving entities:
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

    // Methods for loading entities:
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

}
