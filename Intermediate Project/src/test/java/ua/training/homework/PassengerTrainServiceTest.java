package ua.training.homework;

import org.junit.Before;
import org.junit.Test;
import ua.training.homework.model.entity.PassengerTrain;
import ua.training.homework.model.entity.PassengerWagon;
import ua.training.homework.model.services.PassengerTrainService;

import java.util.Comparator;

import static org.junit.Assert.*;
import static ua.training.homework.model.db.PassengerWagonDB.*;

/**
 * Максим
 * 31.03.2018
 */
public class PassengerTrainServiceTest {
    private PassengerTrainService trainService = new PassengerTrainService();

    @Before
    public void init() {
        trainService.buildPassengerTrain();
    }

    @Test
    public void testSortWagonsByComfortLevel() {
        PassengerTrain train = new PassengerTrain();
        train.getPassengerWagons().add(new PassengerWagon(WAGON_1.getId(), WAGON_1.getWagonType()));
        train.getPassengerWagons().add(new PassengerWagon(WAGON_10.getId(), WAGON_10.getWagonType()));
        train.getPassengerWagons().add(new PassengerWagon(WAGON_14.getId(), WAGON_14.getWagonType()));

        PassengerTrain train1 = new PassengerTrain();
        train1.getPassengerWagons().add(new PassengerWagon(WAGON_14.getId(), WAGON_14.getWagonType()));
        train1.getPassengerWagons().add(new PassengerWagon(WAGON_10.getId(), WAGON_10.getWagonType()));
        train1.getPassengerWagons().add(new PassengerWagon(WAGON_1.getId(), WAGON_1.getWagonType()));

        train.getPassengerWagons().sort(Comparator.comparingInt(
                passengerWagon -> passengerWagon.getWagonType().getComfortLevel()));

        assertEquals(train, train1);
    }

    @Test
    public void testFindWagonsWithPassengersAmountRangeWhenThereIsNoWagonsFound() {
        assertTrue(trainService.findWagonsWithPassengersAmountRange(70, 80).isEmpty());
    }

    @Test
    public void testFindWagonsWithPassengersAmountRangeWhenOffsetIsGreaterThenEnd() {
        assertTrue(trainService.findWagonsWithPassengersAmountRange(30, 20).isEmpty());
    }
}
