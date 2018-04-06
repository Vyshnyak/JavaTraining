package ua.training.homework.model.db;

import ua.training.homework.model.entity.wagons.PassengerWagonType;

import static ua.training.homework.model.entity.wagons.PassengerWagonType.BAGGAGE;

/**
 * Максим
 * 05.04.2018
 */
public enum BaggageWagonDB {
    BAGGAGE_WAGON_1(BAGGAGE), BAGGAGE_WAGON_2(BAGGAGE),
    BAGGAGE_WAGON_3(BAGGAGE), BAGGAGE_WAGON_4(BAGGAGE);

    private double weightCapacity;
    private PassengerWagonType wagonType;

    BaggageWagonDB(PassengerWagonType wagonType) {
        this.weightCapacity = weightCapacity;
        this.wagonType = wagonType;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public PassengerWagonType getWagonType() {
        return wagonType;
    }
}
