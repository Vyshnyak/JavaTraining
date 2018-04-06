package ua.training.homework;

import org.junit.Test;
import ua.training.homework.model.db.PassengerWagonDB;
import ua.training.homework.model.entity.PassengerTrain;
import ua.training.homework.model.entity.locomotives.Locomotive;
import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.PassengerWagon;
import ua.training.homework.model.entity.wagons.PassengerWagonType;
import ua.training.homework.model.entity.wagons.Wagon;
import ua.training.homework.model.services.PassengerTrainService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static ua.training.homework.model.db.BaggageWagonDB.BAGGAGE_WAGON_1;
import static ua.training.homework.model.db.LocomotiveDB.*;
import static ua.training.homework.model.db.PassengerWagonDB.*;
import static ua.training.homework.model.entity.wagons.PassengerWagonType.*;

/**
 * Максим
 * 31.03.2018
 */
public class PassengerTrainServiceTest {
    private PassengerTrainService trainService = new PassengerTrainService();

    @Test
    public void buildTrainTest() {
        trainService.buildPassengerTrain();
        PassengerTrain train = (PassengerTrain) PassengerTrainService.model.getTrain();
        PassengerTrain train1 = new PassengerTrain();
        train1.setLocomotive(new Locomotive(LOCOMOTIVE_1.getMotorman()));
        for (PassengerWagonDB wagon : PassengerWagonDB.values()) {
            train1.getPassengerWagons().add(
                    new PassengerWagon(wagon.getWagonType()));
        }
        train1.getBaggageWagons().add(
                new BaggageWagon(BAGGAGE));
        assertEquals(train1, train);
    }

    @Test
    public void sortWagonsTest() {
        PassengerTrain train = new PassengerTrain();
        train.getPassengerWagons().add(new PassengerWagon(WAGON_1.getWagonType()));
        train.getPassengerWagons().add(new PassengerWagon(WAGON_10.getWagonType()));
        train.getPassengerWagons().add(new PassengerWagon(WAGON_14.getWagonType()));

        PassengerTrain train1 = new PassengerTrain();
        train1.getPassengerWagons().add(new PassengerWagon(WAGON_14.getWagonType()));
        train1.getPassengerWagons().add(new PassengerWagon(WAGON_10.getWagonType()));
        train1.getPassengerWagons().add(new PassengerWagon(WAGON_1.getWagonType()));

        train.getPassengerWagons().sort(Comparator.comparingInt(
                passengerWagon -> ((PassengerWagonType)passengerWagon.getWagonType()).getComfortLevel()));

        assertEquals(train, train1);
    }

    @Test
    public void countPassengersTest() {
        trainService.buildPassengerTrain();
        int passengers = trainService.countPassengers();
        assertEquals(passengers, 580);
    }

    @Test
    public void countBaggageTest() {
        trainService.buildPassengerTrain();
        double baggage = trainService.countBaggage();
        assertEquals(19.0, baggage);
    }

    @Test
    public void findWagonsWithPassengersAmountRangeTest() {
        trainService.buildPassengerTrain();
        List<PassengerWagon> wagons =
                trainService.findWagonsWithPassengersAmountRange(20, 30);
        List<Wagon> wagons1 = new ArrayList<>();
        wagons1.add(new PassengerWagon(WAGON_11.getWagonType()));
        wagons1.add(new PassengerWagon(WAGON_12.getWagonType()));
        wagons1.add(new PassengerWagon(WAGON_13.getWagonType()));
        wagons1.add(new PassengerWagon(WAGON_14.getWagonType()));
        assertEquals(wagons1, wagons);
    }

    @Test(expected = NoSuchElementException.class)
    public void findWagonsWithPassengersAmountRangeWhenThereIsNoWagonsFoundTest() {
        trainService.findWagonsWithPassengersAmountRange(70, 80);
    }

    @Test(expected = NoSuchElementException.class)
    public void findWagonsWithPassengersAmountRangeWhenOffsetIsGreaterThenEndTest() {
        trainService.findWagonsWithPassengersAmountRange(30, 20);
    }
}
