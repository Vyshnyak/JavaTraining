package ua.training.homework.model.db;

import ua.training.homework.model.entity.employees.Motorman;

/**
 * Максим
 * 31.03.2018
 */
public enum LocomotiveDB {
    LOCOMOTIVE_1(new Motorman("Maksym", "Petrov")),
    LOCOMOTIVE_2(new Motorman("Igor", "Sidorov")),
    LOCOMOTIVE_3(new Motorman("Oleh", "Karpov"));

    private Motorman motorman;

    LocomotiveDB(Motorman motorman) {
        this.motorman = motorman;
    }

    public Motorman getMotorman() {
        return motorman;
    }
}
