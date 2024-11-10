package main.java.com.example.propertymanagement.util;

import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Your Name - Your Student ID
 */
public class InputValidator {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PHONE_PATTERN = "^\\d{10}$";
    private static final String ID_NUMBER_PATTERN = "^\\d{9,12}$";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.compile(PHONE_PATTERN).matcher(phoneNumber).matches();
    }

    public static boolean isValidIdNumber(String idNumber) {
        return Pattern.compile(ID_NUMBER_PATTERN).matcher(idNumber).matches();
    }

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }

    public static boolean isValidDate(String dateStr) {
        try {
            DATE_FORMAT.setLenient(false);
            Date date = DATE_FORMAT.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty() && address.length() >= 5;
    }

    public static boolean isValidFloorArea(double floorArea) {
        return floorArea > 0;
    }

    public static boolean isValidNumberOfRooms(int numberOfRooms) {
        return numberOfRooms > 0;
    }

    public static boolean isValidBusinessType(String businessType) {
        return businessType != null && !businessType.trim().isEmpty();
    }

    public static boolean isValidPaymentMethod(String paymentMethod) {
        return paymentMethod != null && !paymentMethod.trim().isEmpty();
    }

    public static Date parseDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
