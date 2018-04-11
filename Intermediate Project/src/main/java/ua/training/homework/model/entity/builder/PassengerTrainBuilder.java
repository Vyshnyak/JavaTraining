package ua.training.homework.model.entity.builder;

import ua.training.homework.model.db.PassengerWagonDB;
import ua.training.homework.model.entity.*;
import ua.training.homework.model.entity.Locomotive;
import ua.training.homework.model.entity.BaggageWagon;
import ua.training.homework.model.entity.PassengerWagon;

import static ua.training.homework.model.db.BaggageWagonDB.BAGGAGE_WAGON_1;
import static ua.training.homework.model.db.BaggageWagonDB.BAGGAGE_WAGON_2;
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
            passengerTrain.getPassengerWagons().add(
                    new PassengerWagon(wagon.getId(), wagon.getWagonType()));
        }
        passengerTrain.getBaggageWagons().add(
                new BaggageWagon(BAGGAGE_WAGON_1.getId(), BAGGAGE_WAGON_1.getWagonType()));
        passengerTrain.getBaggageWagons().add(
                new BaggageWagon(BAGGAGE_WAGON_2.getId(), BAGGAGE_WAGON_2.getWagonType()));
    }

    @Override
    public PassengerTrain getTrain() {
        return passengerTrain;
    }
}
