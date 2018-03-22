package ua.training.homework;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Максим
 * 22.03.2018
 */
public class ElementRepetitionCounterTest {
    private Map<Integer, Integer> rightResult = new HashMap<>();

    @Before
    public void before() {
        rightResult.put(2, 1);
        rightResult.put(3, 1);
        rightResult.put(4, 4);
        rightResult.put(5, 3);
        rightResult.put(6, 1);
        rightResult.put(7, 1);
    }
    @Test
    public void test() {
        ElementRepetitionCounter elementCounter =
                new ElementRepetitionCounter(Arrays.asList(4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7));
        Map<Integer, Integer> result = elementCounter.countElementsRepetition();
        assertEquals(result, rightResult);
    }
}
