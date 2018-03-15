package ua.training.homework.entity;

import ua.training.homework.view.Constants;

/**
 * Максим
 * 14.03.2018
 */
public class ProperFraction extends Fraction {
    public ProperFraction(int numerator, int denominator) {
        super(numerator, denominator);
        checkProperFraction(numerator, denominator);
    }

    public ProperFraction(int denominator) {
        this(1, denominator);
    }

    private void checkProperFraction(int numerator, int denominator) {
        if (numerator >= denominator) {
            throw new IllegalArgumentException(Constants.WRONG_PROPER_FRACTION);
        }
    }
}
