package ua.training.homework.model.entity.builder;

import ua.training.homework.model.db.PassengerWagonDB;
import ua.training.homework.model.entity.*;
import ua.training.homework.model.entity.locomotives.Locomotive;
import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.PassengerWagon;
import ua.training.homework.model.entity.wagons.PassengerWagonType;

import static ua.training.homework.model.db.BaggageWagonDB.*;
import static ua.training.homework.model.db.LocomotiveDB.*;
import static ua.training.homework.model.entity.wagons.PassengerWagonType.*;

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
            passengerTrain.getPassengerWagons().add(
                    new PassengerWagon(wagon.getWagonType()));
        }
        passengerTrain.getBaggageWagons().add(
                new BaggageWagon(BAGGAGE));
    }

    @Override
    public Train getTrain() {
        return passengerTrain;
    }
}
