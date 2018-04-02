package ua.training.homework.model.entity;

import ua.training.homework.model.entity.locomotives.Locomotive;
import ua.training.homework.model.entity.wagons.Wagon;

import java.util.ArrayList;
import java.util.List;

/**
 * Максим
 * 30.03.2018
 */
public abstract class Train {
    private Locomotive locomotive;
    private List<Wagon> wagons = new ArrayList<>();

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    public void addWagon(Wagon wagon) {
        wagons.add(wagon);
    }

    public void addWagon(int index, Wagon wagon) {
        wagons.add(index, wagon);
    }

    public void removeWagon(int index) {
        wagons.remove(index);
    }

    public void removeWagon(Wagon wagon) {
        wagons.remove(wagon);
    }

    public abstract String drawTrain();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Train that = (Train) obj;

        return locomotive != null ? locomotive.equals(that.locomotive) : that.locomotive == null &&
                wagons != null ? wagons.equals(that.wagons) : that.wagons == null;
    }

    @Override
    public int hashCode() {
        int result = locomotive != null ? locomotive.hashCode() : 0;
        result = 31 * result + (wagons != null ? wagons.hashCode() : 0);
        return result;
    }
}
