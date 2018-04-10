package ua.training.homework.model.entity.locomotives;

import ua.training.homework.model.entity.employees.Motorman;

/**
 * Максим
 * 30.03.2018
 */
public class Locomotive {
    private Motorman motorman;

    public Locomotive(Motorman motorman) {
        this.motorman = motorman;
    }

    public Motorman getMotorman() {
        return motorman;
    }

    public void setMotorman(Motorman motorman) {
        this.motorman = motorman;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Locomotive that = (Locomotive) obj;

        return motorman != null ? motorman.equals(that.motorman) : that.motorman == null;
    }

    @Override
    public int hashCode() {
        return motorman != null ? motorman.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "L";
    }
}
