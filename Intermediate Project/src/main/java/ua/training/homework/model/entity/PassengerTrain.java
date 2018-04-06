package ua.training.homework.model.entity;

import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.PassengerWagon;

import java.util.ArrayList;
import java.util.List;

/**
 * Максим
 * 04.04.2018
 */
public class PassengerTrain extends Train {
    private List<PassengerWagon> passengerWagons = new ArrayList<>();
    private List<BaggageWagon> baggageWagons = new ArrayList<>();

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
        if (!super.equals(o)) return false;

        PassengerTrain train = (PassengerTrain) o;
        return passengerWagons != null ? passengerWagons.equals(train.passengerWagons) : train.passengerWagons != null &&
                baggageWagons != null ? baggageWagons.equals(train.baggageWagons) : train.baggageWagons == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (passengerWagons != null ? passengerWagons.hashCode() : 0);
        result = 31 * result + (baggageWagons != null ? baggageWagons.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getLocomotive() +
                baggageWagons.toString() +
                passengerWagons.toString();
    }
}
