package ua.training.homework.model.db;

import ua.training.homework.model.entity.wagons.PassengerWagon.WagonType;

import static ua.training.homework.model.entity.wagons.PassengerWagon.WagonType.*;

/**
 * Максим
 * 31.03.2018
 */
public enum PassengerWagonDB {
    WAGON_1(42, PLATZCART), WAGON_2(48, PLATZCART), WAGON_3(49, PLATZCART),
    WAGON_4(45, PLATZCART), WAGON_5(50, PLATZCART), WAGON_6(53, PLATZCART),
    WAGON_7(47, PLATZCART), WAGON_8(48, PLATZCART), WAGON_9(51, PLATZCART),
    WAGON_10(30, COUPE), WAGON_11(27, COUPE),
    WAGON_12(29, COUPE), WAGON_13(22, COUPE),
    WAGON_14(20, SV), WAGON_15(19, SV);

    private int occupiedSeats;
    private int amountOfSeats;
    private WagonType comfortLevel;

    PassengerWagonDB(int occupiedSeats, WagonType comfortLevel) {
        this.occupiedSeats = occupiedSeats;
        this.comfortLevel = comfortLevel;
        this.amountOfSeats = comfortLevel.getAmountOfSeats();
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public WagonType getComfortLevel() {
        return comfortLevel;
    }
}
