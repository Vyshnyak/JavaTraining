package ua.training.homework.model.services;

import ua.training.homework.model.Model;
import ua.training.homework.model.entity.BaggageWagon;
import ua.training.homework.model.entity.PassengerWagon;
import ua.training.homework.model.entity.builder.Director;
import ua.training.homework.model.entity.builder.PassengerTrainBuilder;

import java.util.Comparator;
import java.util.List;
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
        List<PassengerWagon> passengerWagons = model.getTrain().getPassengerWagons();
        List<BaggageWagon> baggageWagons = model.getTrain().getBaggageWagons();
        for (PassengerWagon wagon : passengerWagons) {
            wagon.setSeatsOccupancy(random.nextInt(wagon.getWagonType().getCapacity()));
        }
        for (BaggageWagon wagon : baggageWagons) {
            wagon.setWeightOccupancy(random.nextDouble(wagon.getWagonType().getCapacity()));
        }
    }

    public void sortWagonsByComfortLevel() {
        model.getTrain().getPassengerWagons()
                .sort(Comparator.comparingInt(passengerWagon ->
                        passengerWagon.getWagonType().getComfortLevel()));
    }

    public int countPassengers() {
        return model.getTrain().getPassengerWagons()
                .stream()
                .mapToInt(PassengerWagon::getSeatsOccupancy)
                .sum();
    }

    public double countBaggage() {
        return model.getTrain().getBaggageWagons()
                .stream()
                .mapToDouble(BaggageWagon::getWeightOccupancy)
                .sum();
    }

    public List<PassengerWagon> findWagonsWithPassengersAmountRange(int start, int end) {
        return model.getTrain().getPassengerWagons()
                .stream()
                .filter(w -> w.getSeatsOccupancy() >= start &&
                             w.getSeatsOccupancy() < end)
                .collect(Collectors.toList());
    }
}
