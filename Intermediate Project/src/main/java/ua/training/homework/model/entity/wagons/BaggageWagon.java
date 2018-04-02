package ua.training.homework.model.entity.wagons;

/**
 * Максим
 * 31.03.2018
 */
public class BaggageWagon extends Wagon {
    private int loadCapacity;
    private int loadAmount;

    public BaggageWagon(int loadCapacity, int loadAmount) {
        this.loadCapacity = loadCapacity;
        this.loadAmount = loadAmount;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public int getLoadAmount() {
        return loadAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BaggageWagon that = (BaggageWagon) obj;

        return loadCapacity == that.loadCapacity &&
                loadAmount == that.loadAmount;
    }

    @Override
    public int hashCode() {
        int result = loadCapacity;
        result = 31 * result + loadAmount;
        return result;
    }

    @Override
    public String toString() {
        return String.format("{B %d/%d}", loadAmount, loadCapacity);
    }
}
