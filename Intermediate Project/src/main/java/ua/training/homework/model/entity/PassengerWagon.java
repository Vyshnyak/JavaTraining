package ua.training.homework.model.entity;

/**
 * Максим
 * 30.03.2018
 */
public class PassengerWagon extends Wagon {
    private int seatsCapacity;
    private int seatsOccupancy;

    public PassengerWagon(int id, WagonType wagonType) {
        super(id, wagonType);
        this.seatsCapacity = wagonType.getCapacity();
    }

    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    public int getSeatsOccupancy() {
        return seatsOccupancy;
    }

    public void setSeatsOccupancy(int seatsOccupancy) {
        this.seatsOccupancy = seatsOccupancy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerWagon wagon = (PassengerWagon) o;

        if (seatsCapacity != wagon.seatsCapacity) return false;
        return seatsOccupancy == wagon.seatsOccupancy;
    }

    @Override
    public int hashCode() {
        int result = seatsCapacity;
        result = 31 * result + seatsOccupancy;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%d | %d/%d", getWagonType().getName(), getId(), seatsOccupancy, seatsCapacity);
    }
}
