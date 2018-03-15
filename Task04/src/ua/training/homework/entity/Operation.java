package ua.training.homework.entity;

/**
 * Максим
 * 14.03.2018
 */
public enum Operation {
    ADDING("+"), SUBTRACTION("-"), MULTIPLYING("*"), DIVIDING("/");
    String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
