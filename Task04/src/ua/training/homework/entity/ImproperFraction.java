package ua.training.homework.entity;

import ua.training.homework.view.Constants;

/**
 * Максим
 * 15.03.2018
 */
public class ImproperFraction extends Fraction {
    public ImproperFraction(int numerator, int denominator) {
        super(numerator, denominator);
        checkProperFraction(numerator, denominator);
    }

    public ImproperFraction(int numerator) {
        this(numerator, 1);
    }

    private void checkProperFraction(int numerator, int denominator) {
        if (numerator < denominator) {
            throw new IllegalArgumentException(Constants.WRONG_INPROPER_FRACTION);
        }
    }
}
