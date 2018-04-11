package ua.training.homework.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Максим
 * 04.04.2018
 */
public class PassengerTrain {
    private Locomotive locomotive;
    private List<PassengerWagon> passengerWagons = new ArrayList<>();
    private List<BaggageWagon> baggageWagons = new ArrayList<>();

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<PassengerWagon> getPassengerWagons() {
        return passengerWagons;
    }

    public void setPassengerWagons(List<PassengerWagon> passengerWagons) {
        this.passengerWagons = passengerWagons;
    }

    public List<BaggageWagon> getBaggageWagons() {
        return baggageWagons;
    }

    public void setBaggageWagons(List<BaggageWagon> baggageWagons) {
        this.baggageWagons = baggageWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerTrain train = (PassengerTrain) o;

        if (locomotive != null ? !locomotive.equals(train.locomotive) : train.locomotive != null) return false;
        if (passengerWagons != null ? !passengerWagons.equals(train.passengerWagons) : train.passengerWagons != null)
            return false;
        return baggageWagons != null ? baggageWagons.equals(train.baggageWagons) : train.baggageWagons == null;
    }

    @Override
    public int hashCode() {
        int result = locomotive != null ? locomotive.hashCode() : 0;
        result = 31 * result + (passengerWagons != null ? passengerWagons.hashCode() : 0);
        result = 31 * result + (baggageWagons != null ? baggageWagons.hashCode() : 0);
        return result;
    }
}
