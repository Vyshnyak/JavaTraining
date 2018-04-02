package ua.training.homework.model.db;

/**
 * Максим
 * 31.03.2018
 */
public enum BaggageWagonDB {
    BAGGAGE_WAGON_1(20, 19), BAGGAGE_WAGON_2(20, 18), BAGGAGE_WAGON_3(20, 20);

    private int loadCapacity;
    private int loadAmount;

    BaggageWagonDB(int loadCapacity, int loadAmount) {
        this.loadCapacity = loadCapacity;
        this.loadAmount = loadAmount;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getLoadAmount() {
        return loadAmount;
    }
}
