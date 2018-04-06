package ua.training.homework.model.entity;

import ua.training.homework.model.entity.locomotives.Locomotive;

/**
 * Максим
 * 30.03.2018
 */
public abstract class Train {
    private Locomotive locomotive;

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Train train = (Train) o;

        return locomotive != null ? locomotive.equals(train.locomotive) : train.locomotive == null;
    }

    @Override
    public int hashCode() {
        return locomotive != null ? locomotive.hashCode() : 0;
    }
}
