package ua.training.homework.model.db;

import ua.training.homework.model.entity.employees.Motorman;

import static ua.training.homework.model.db.MotormanDB.*;

/**
 * Максим
 * 31.03.2018
 */
public enum LocomotiveDB {
    LOCOMOTIVE_1(new Motorman(MOTORMAN_1.getFirstName(), MOTORMAN_1.getLastName())),
    LOCOMOTIVE_2(new Motorman(MOTORMAN_2.getFirstName(), MOTORMAN_2.getLastName())),
    LOCOMOTIVE_3(new Motorman(MOTORMAN_3.getFirstName(), MOTORMAN_3.getLastName()));

    private Motorman motorman;

    LocomotiveDB(Motorman motorman) {
        this.motorman = motorman;
    }

    public Motorman getMotorman() {
        return motorman;
    }
}
