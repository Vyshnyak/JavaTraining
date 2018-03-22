package ua.training.homework;

import java.util.*;

/**
 * Максим
 * 22.03.2018
 */
public class ElementRepetitionCounter {
    private List<Integer> elements;

    public ElementRepetitionCounter(List<Integer> elements) {
        this.elements = elements;
    }

    public Map<Integer, Integer> countElementsRepetition() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer element : elements) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }
}
