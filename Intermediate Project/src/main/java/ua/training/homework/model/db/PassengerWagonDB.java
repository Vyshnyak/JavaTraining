package ua.training.homework.model.db;

import ua.training.homework.model.entity.WagonType;

import static ua.training.homework.model.entity.WagonType.*;

/**
 * Максим
 * 31.03.2018
 */
public enum PassengerWagonDB {
    WAGON_1(1, PLATZCART), WAGON_2(2, PLATZCART), WAGON_3(3, PLATZCART),
    WAGON_4(4, PLATZCART), WAGON_5(5, PLATZCART), WAGON_6(6, PLATZCART),
    WAGON_7(7, PLATZCART), WAGON_8(8, PLATZCART), WAGON_9(9, PLATZCART),
    WAGON_10(1, COUPE), WAGON_11(2, COUPE),
    WAGON_12(3, COUPE), WAGON_13(4, COUPE),
    WAGON_14(1, SV), WAGON_15(2, SV);

    private int id;
    private WagonType wagonType;

    PassengerWagonDB(int id, WagonType wagonType) {
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
