package ua.training.homework.model.entity;

import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.Wagon;

/**
 * Максим
 * 31.03.2018
 */
public class PassengerTrain extends Train {
    private BaggageWagon baggageWagon;

    public BaggageWagon getBaggageWagon() {
        return baggageWagon;
    }

    public void setBaggageWagon(BaggageWagon baggageWagon) {
        this.baggageWagon = baggageWagon;
    }

    @Override
    public String drawTrain() {
        StringBuilder builder = new StringBuilder();
        builder.append(getLocomotive());
        for (Wagon wagon : getWagons()) {
            builder.append(wagon);
        }
        builder.append(baggageWagon);
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass() ||
                !(super.equals(obj))) {
            return false;
        }

        PassengerTrain that = (PassengerTrain) obj;

        return baggageWagon != null ? baggageWagon.equals(that.baggageWagon) :
                that.baggageWagon == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (baggageWagon != null ? baggageWagon.hashCode() : 0);
        return result;
    }
}
