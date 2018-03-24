package ua.training.homework;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Максим
 * 24.03.2018
 */
public class MyArrayList<E> extends ArrayList<E> {
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
}
