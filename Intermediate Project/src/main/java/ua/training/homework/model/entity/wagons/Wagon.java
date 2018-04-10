package ua.training.homework.model.entity.wagons;

/**
 * Максим
 * 04.04.2018
 */
public abstract class Wagon {
    private int id;
    private WagonType wagonType;

    public Wagon(int id, WagonType wagonType) {
        this.id = id;
        this.wagonType = wagonType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    public void setWagonType(WagonType wagonType) {
        this.wagonType = wagonType;
    }
}
