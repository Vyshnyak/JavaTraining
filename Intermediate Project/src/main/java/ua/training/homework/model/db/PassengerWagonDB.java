package ua.training.homework.model.db;

import ua.training.homework.model.entity.wagons.PassengerWagonType;

import static ua.training.homework.model.entity.wagons.PassengerWagonType.*;

/**
 * Максим
 * 31.03.2018
 */
public enum PassengerWagonDB {
    WAGON_1(PLATZCART), WAGON_2(PLATZCART), WAGON_3(PLATZCART),
    WAGON_4(PLATZCART), WAGON_5(PLATZCART), WAGON_6(PLATZCART),
    WAGON_7(PLATZCART), WAGON_8(PLATZCART), WAGON_9(PLATZCART),
    WAGON_10(COUPE), WAGON_11(COUPE),
    WAGON_12(COUPE), WAGON_13(COUPE),
    WAGON_14(SV), WAGON_15(SV);

    private int amountOfSeats;
    private PassengerWagonType wagonType;

    PassengerWagonDB(PassengerWagonType wagonType) {
        this.wagonType = wagonType;
        this.amountOfSeats = wagonType.getCapacity();
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public PassengerWagonType getWagonType() {
        return wagonType;
    }
}
