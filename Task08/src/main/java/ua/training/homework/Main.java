package ua.training.homework;

import java.util.Arrays;
import java.util.Map;

/**
 * Максим
 * 22.03.2018
 */
public class Main {
    public static void main(String[] args) {
        ElementRepetitionCounter repetitionCounter =
                new ElementRepetitionCounter(Arrays.asList(4, 5, 6, 4, 5, 3, 4, 2, 4, 5, 7));
        Map<Integer, Integer> result = repetitionCounter.countElementsRepetition();

        for (Integer key : result.keySet()) {
            System.out.println(key + " - " + result.get(key));
        }
    }
}
