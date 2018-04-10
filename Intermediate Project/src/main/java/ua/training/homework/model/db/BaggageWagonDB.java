package ua.training.homework.model.db;

import ua.training.homework.model.entity.wagons.WagonType;

import static ua.training.homework.model.entity.wagons.WagonType.BAGGAGE;

/**
 * Максим
 * 05.04.2018
 */
public enum BaggageWagonDB {
    BAGGAGE_WAGON_1(1, BAGGAGE), BAGGAGE_WAGON_2(2, BAGGAGE),
    BAGGAGE_WAGON_3(3, BAGGAGE), BAGGAGE_WAGON_4(4, BAGGAGE);

    private int id;
    private WagonType wagonType;

    BaggageWagonDB(int id, WagonType wagonType) {
        this.id = id;
        this.wagonType = wagonType;
    }

    public int getId() {
        return id;
    }
    public WagonType getWagonType() {
        return wagonType;
    }
}
