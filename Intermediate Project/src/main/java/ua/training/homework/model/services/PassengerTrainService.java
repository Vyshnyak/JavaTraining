package ua.training.homework.model.services;

import ua.training.homework.model.Model;
import ua.training.homework.model.entity.PassengerTrain;
import ua.training.homework.model.entity.wagons.BaggageWagon;
import ua.training.homework.model.entity.wagons.PassengerWagon;
import ua.training.homework.model.entity.wagons.PassengerWagonType;
import ua.training.homework.model.entity.builder.Director;
import ua.training.homework.model.entity.builder.PassengerTrainBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Максим
 * 31.03.2018
 */
public class PassengerTrainService {
    public static Model model = new Model();

    public void buildPassengerTrain() {
        Director director = new Director(new PassengerTrainBuilder());
        model.setTrain(director.buildTrain());
    }

    public void fillTrainRandomly() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<PassengerWagon> passengerWagons =
                ((PassengerTrain) model.getTrain()).getPassengerWagons();

        List<BaggageWagon> baggageWagons =
                ((PassengerTrain) model.getTrain()).getBaggageWagons();

        for (PassengerWagon wagon : passengerWagons) {
            wagon.setSeatsOccupancy(random.nextInt(
                    ((PassengerWagonType)wagon.getWagonType()).getCapacity()));
        }

        for (BaggageWagon wagon : baggageWagons) {
            wagon.setWeightOccupancy(random.nextDouble(
                    ((PassengerWagonType)wagon.getWagonType()).getCapacity()));
        }
    }

    public void sortWagonsByComfortLevel() {
        ((PassengerTrain) model.getTrain())
                .getPassengerWagons()
                .sort(Comparator.comparingInt(passengerWagon ->
                        ((PassengerWagonType) passengerWagon.getWagonType()).getComfortLevel()));
    }

    public int countPassengers() {
        return ((PassengerTrain) model.getTrain()).getPassengerWagons()
                .stream()
                .mapToInt(PassengerWagon::getSeatsOccupancy)
                .sum();
    }

    public double countBaggage() {
        return ((PassengerTrain) model.getTrain()).getBaggageWagons()
                .stream()
                .mapToDouble(BaggageWagon::getWeightOccupancy)
                .sum();
    }

    public List<PassengerWagon> findWagonsWithPassengersAmountRange(int start, int end) {
        List<PassengerWagon> wagons = ((PassengerTrain) model.getTrain()).getPassengerWagons()
                .stream()
                .filter(w -> w.getSeatsOccupancy() >= start &&
                             w.getSeatsOccupancy() < end)
                .collect(Collectors.toList());

        if (wagons.isEmpty()) {
            throw new NoSuchElementException();
        }
        return wagons;
    }
}
