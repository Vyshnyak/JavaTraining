package ua.training.homework.model.entity.wagons;

/**
 * Максим
 * 03.04.2018
 */
public enum PassengerWagonType implements WagonType {
    PLATZCART(54, "P", 3), COUPE(36, "C", 2), SV(21, "SV", 1), BAGGAGE(20, "B", 0),;

    private int capacity;
    private String name;
    private int comfortLevel;

    PassengerWagonType(int amountOfSeats, String name, int comfortLevel) {
        this.capacity = amountOfSeats;
        this.name = name;
        this.comfortLevel = comfortLevel;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}
