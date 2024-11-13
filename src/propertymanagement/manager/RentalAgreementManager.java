package propertymanagement.manager;

import java.util.List;

public interface RentalAgreementManager {
    // Adding entities to Database's List
    boolean add(Object o);

    // Get entities by ID
    Object getByID(String id);

    // Get The List Of Entities:
    List<?> getAll();

    // Update the entities:
    void update(Object o);

    // Remove entities from list:
    boolean remove(Object o);

    // List of expired Rental Agreement:
    List<?> getExpiredRentalAgreements();

}
