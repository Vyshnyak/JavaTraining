package ua.training.homework.model.entity.builder;

import ua.training.homework.model.db.PassengerWagonDB;
import ua.training.homework.model.entity.*;
import ua.training.homework.model.entity.locomotives.Locomotive;
import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.PassengerWagon;

import static ua.training.homework.model.db.BaggageWagonDB.*;
import static ua.training.homework.model.db.LocomotiveDB.*;

/**
 * Максим
 * 30.03.2018
 */
public class PassengerTrainBuilder extends TrainBuilder {
    private PassengerTrain passengerTrain = new PassengerTrain();

    @Override
    public void buildLocomotive() {
        passengerTrain.setLocomotive(new Locomotive(LOCOMOTIVE_1.getMotorman()));
    }

    @Override
    public void buildWagons() {
        for (PassengerWagonDB wagon : PassengerWagonDB.values()) {
            passengerTrain.addWagon(
                    new PassengerWagon(wagon.getOccupiedSeats(), wagon.getComfortLevel()));
        }
        passengerTrain.setBaggageWagon(
                new BaggageWagon(BAGGAGE_WAGON_1.getLoadCapacity(), BAGGAGE_WAGON_1.getLoadAmount()));
    }

    @Override
    public Train getTrain() {
        return passengerTrain;
    }
}
