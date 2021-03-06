package ua.training.homework.model.entity.builder;

import ua.training.homework.model.entity.PassengerTrain;

/**
 * Максим
 * 30.03.2018
 */
public abstract class TrainBuilder {
    public abstract void buildLocomotive();
    public abstract void buildWagons();
    public abstract PassengerTrain getTrain();
}
