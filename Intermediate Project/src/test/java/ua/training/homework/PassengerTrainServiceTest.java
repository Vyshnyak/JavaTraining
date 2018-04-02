package ua.training.homework;

import org.junit.Test;
import ua.training.homework.model.db.PassengerWagonDB;
import ua.training.homework.model.entity.PassengerTrain;
import ua.training.homework.model.entity.locomotives.Locomotive;
import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.PassengerWagon;
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
            train1.addWagon(
                    new PassengerWagon(wagon.getOccupiedSeats(), wagon.getComfortLevel()));
        }
        train1.setBaggageWagon(
                new BaggageWagon(BAGGAGE_WAGON_1.getLoadCapacity(), BAGGAGE_WAGON_1.getLoadAmount()));
        assertEquals(train, train1);
    }

    @Test
    public void sortWagonsTest() {
        PassengerTrain train = new PassengerTrain();
        train.addWagon(new PassengerWagon(WAGON_1.getOccupiedSeats(), WAGON_1.getComfortLevel()));
        train.addWagon(new PassengerWagon(WAGON_10.getOccupiedSeats(), WAGON_10.getComfortLevel()));
        train.addWagon(new PassengerWagon(WAGON_14.getOccupiedSeats(), WAGON_14.getComfortLevel()));

        PassengerTrain train1 = new PassengerTrain();
        train1.addWagon(new PassengerWagon(WAGON_14.getOccupiedSeats(), WAGON_14.getComfortLevel()));
        train1.addWagon(new PassengerWagon(WAGON_10.getOccupiedSeats(), WAGON_10.getComfortLevel()));
        train1.addWagon(new PassengerWagon(WAGON_1.getOccupiedSeats(), WAGON_1.getComfortLevel()));

        train.getWagons().sort(Comparator.comparingInt(
                passengerWagon -> ((PassengerWagon) passengerWagon).getWagonType().getComfortLevel()));

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
        int baggage = trainService.countBaggage();
        assertEquals(baggage, 19);
    }

    @Test
    public void findWagonsWithPassengersAmountRangeTest() {
        trainService.buildPassengerTrain();
        List<Wagon> wagons = trainService.findWagonsWithPassengersAmountRange(20, 30);
        List<Wagon> wagons1 = new ArrayList<>();
        wagons1.add(new PassengerWagon(WAGON_11.getOccupiedSeats(), WAGON_11.getComfortLevel()));
        wagons1.add(new PassengerWagon(WAGON_12.getOccupiedSeats(), WAGON_12.getComfortLevel()));
        wagons1.add(new PassengerWagon(WAGON_13.getOccupiedSeats(), WAGON_13.getComfortLevel()));
        wagons1.add(new PassengerWagon(WAGON_14.getOccupiedSeats(), WAGON_14.getComfortLevel()));
        assertEquals(wagons, wagons1);
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
