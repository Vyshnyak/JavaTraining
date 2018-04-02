package ua.training.homework.model.services;

import ua.training.homework.model.Model;
import ua.training.homework.model.entity.PassengerTrain;
import ua.training.homework.model.entity.wagons.PassengerWagon;
import ua.training.homework.model.entity.wagons.Wagon;
import ua.training.homework.model.entity.builder.Director;
import ua.training.homework.model.entity.builder.PassengerTrainBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
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

    public void sortWagonsByComfortLevel() {
        model.getTrain().getWagons().sort(Comparator.comparingInt(
                passengerWagon -> ((PassengerWagon) passengerWagon).getWagonType().getComfortLevel()));
    }

    public int countPassengers() {
        return model.getTrain().getWagons().stream()
                .mapToInt(w -> ((PassengerWagon)w).getOccupiedSeats())
                .sum();
    }

    public int countBaggage() {
        return ((PassengerTrain) model.getTrain()).getBaggageWagon().getLoadAmount();
    }

    public List<Wagon> findWagonsWithPassengersAmountRange(int offset, int end) {
        List<Wagon> wagons = model.getTrain().getWagons().stream()
                .filter(w -> ((PassengerWagon) w).getOccupiedSeats() >= offset &&
                             ((PassengerWagon) w).getOccupiedSeats() < end)
                .collect(Collectors.toList());

        if (wagons.isEmpty()) {
            throw new NoSuchElementException();
        }
        return wagons;
    }
}
