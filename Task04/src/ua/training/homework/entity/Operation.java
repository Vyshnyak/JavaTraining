package ua.training.homework.entity;

/**
 * Максим
 * 14.03.2018
 */
public enum Operation {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
