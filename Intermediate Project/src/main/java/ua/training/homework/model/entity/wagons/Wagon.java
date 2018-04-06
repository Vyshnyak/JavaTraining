package ua.training.homework.model.entity.wagons;

/**
 * Максим
 * 04.04.2018
 */
public abstract class Wagon {
    private WagonType wagonType;

    public Wagon(WagonType wagonType) {
        this.wagonType = wagonType;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    public void setWagonType(WagonType wagonType) {
        this.wagonType = wagonType;
    }
}
