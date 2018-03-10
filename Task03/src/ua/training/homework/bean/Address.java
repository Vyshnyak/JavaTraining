package ua.training.homework.bean;

import ua.training.homework.view.Constants;

/**
 * Address bean that consists of the index, city, street,
 * house number and apartment number to be used as a note field
 * object
 */
public class Address implements Cloneable {
    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address(String index, String city, String street,
                   String houseNumber, String apartmentNumber) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    /**
     * Clones this address object so it can't be change out from the class area
     *
     * @return  the clone of the address object from which this method was called
     *
     * @throws CloneNotSupportedException
     *         if cloning is not supported
     */
    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    /**
     * Returns a full address that consists of all address fields (index, city,
     * street, house number, apartment number)
     *
     * @return  the string represented as a full address that consists
     *          of all it's fields
     */
    @Override
    public String toString() {
        return String.format(Constants.FULL_ADDRESS_PATTERN,
                index, city, street, houseNumber, apartmentNumber);
    }
}
