package ua.training.homework.model.db;

/**
 * Максим
 * 03.04.2018
 */
public enum  MotormanDB {
    MOTORMAN_1("Maksym", "Petrov"),
    MOTORMAN_2("Igor", "Sidorov"),
    MOTORMAN_3("Oleh", "Karpov");

    private String firstName;
    private String lastName;

    MotormanDB(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
