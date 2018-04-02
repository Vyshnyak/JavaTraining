package ua.training.homework.model.entity.wagons;

/**
 * Максим
 * 30.03.2018
 */
public class PassengerWagon extends Wagon {
    public enum WagonType {
        PLATZCART(54, "P", 3), COUPE(36, "C", 2), SV(21, "SV", 1);

        private int amountOfSeats;
        private String name;
        private int comfortLevel;

        WagonType(int amountOfSeats, String name, int comfortLevel) {
            this.amountOfSeats = amountOfSeats;
            this.name = name;
            this.comfortLevel = comfortLevel;
        }

        public int getAmountOfSeats() {
            return amountOfSeats;
        }

        public String getName() {
            return name;
        }

        public int getComfortLevel() {
            return comfortLevel;
        }
    }

    private int occupiedSeats;
    private int amountOfSeats;
    private WagonType wagonType;

    public PassengerWagon(int occupiedSeats, WagonType comfortLevel) {
        this.occupiedSeats = occupiedSeats;
        this.amountOfSeats = comfortLevel.getAmountOfSeats();
        this.wagonType = comfortLevel;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public WagonType getWagonType() {
        return wagonType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        PassengerWagon that = (PassengerWagon) obj;

        return occupiedSeats == that.occupiedSeats &&
                amountOfSeats == that.amountOfSeats &&
                wagonType == that.wagonType;
    }

    @Override
    public int hashCode() {
        int result = occupiedSeats;
        result = 31 * result + amountOfSeats;
        result = 31 * result + (wagonType != null ? wagonType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("{%s %d/%d}", wagonType.getName(), occupiedSeats, amountOfSeats);
    }
}
