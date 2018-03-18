package ua.training.homework.model.entity;

import ua.training.homework.view.Constants;

/**
 * Address information that consists of the index, city, street,
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

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public String toString() {
        return String.format(Constants.FULL_ADDRESS_PATTERN,
                index, city, street, houseNumber, apartmentNumber);
    }
}
