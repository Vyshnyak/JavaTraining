package ua.training.homework.model.entity;

/**
 * Максим
 * 31.03.2018
 */
public class BaggageWagon extends Wagon {
    private double weightCapacity;
    private double weightOccupancy;

    public BaggageWagon(int id, WagonType wagonType) {
        super(id, wagonType);
        this.weightCapacity = wagonType.getCapacity();
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public double getWeightOccupancy() {
        return weightOccupancy;
    }

    public void setWeightOccupancy(double weightOccupancy) {
        this.weightOccupancy = weightOccupancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaggageWagon wagon = (BaggageWagon) o;

        if (Double.compare(wagon.weightCapacity, weightCapacity) != 0) return false;
        return Double.compare(wagon.weightOccupancy, weightOccupancy) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weightCapacity);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weightOccupancy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%d | %.2f/%.2f", getWagonType().getName(), getId(), weightOccupancy, weightCapacity);
    }
}
