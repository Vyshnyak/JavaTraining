package ua.training.homework.model.entity.employees;

/**
 * Максим
 * 30.03.2018
 */
public class Motorman {
    private String firstName;
    private String lastName;

    public Motorman(String firstName, String sureName) {
        this.firstName = firstName;
        this.lastName = sureName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Motorman that = (Motorman) obj;

        return firstName != null ? firstName.equals(that.firstName) : that.firstName == null &&
                lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
