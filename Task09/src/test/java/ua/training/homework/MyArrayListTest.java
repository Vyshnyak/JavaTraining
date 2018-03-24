package ua.training.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Максим
 * 24.03.2018
 */
public class MyArrayListTest {
    private MyArrayList<Integer> myArrayList = new MyArrayList<>();

    @Before
    public void init() {
        myArrayList.add(1);
        myArrayList.add(2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenRemoveElementByIndexThenUnsupportedOperationException() {
        myArrayList.remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenRemoveElementByObjectThenUnsupportedOperationException() {
        myArrayList.remove(1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenRemoveGivenCollectionThenUnsupportedOperationException() {
        myArrayList.removeAll(Arrays.asList(1, 2));
    }
}
