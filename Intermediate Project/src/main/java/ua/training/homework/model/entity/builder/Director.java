package ua.training.homework.model.entity.builder;

import ua.training.homework.model.entity.Train;

/**
 * Максим
 * 30.03.2018
 */
public class Director {
    private TrainBuilder builder;

    public Director(TrainBuilder builder) {
        this.builder = builder;
    }

    public Train buildTrain() {
        builder.buildLocomotive();
        builder.buildWagons();
        return builder.getTrain();
    }
}
