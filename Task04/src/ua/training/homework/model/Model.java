package ua.training.homework.model;

import ua.training.homework.model.entity.Fraction;
import ua.training.homework.model.entity.Operation;
import ua.training.homework.view.Constants;

/**
 * Максим
 * 14.03.2018
 */
public class Model {
    private Fraction firstFraction;
    private Fraction secondFraction;
    private Fraction operationResult;

    public void setFirstFraction(Fraction firstFraction) {
        this.firstFraction = firstFraction;
    }

    public void setSecondFraction(Fraction secondFraction) {
        this.secondFraction = secondFraction;
    }

    public Fraction getFirstFraction() {
        return firstFraction;
    }

    public Fraction getSecondFraction() {
        return secondFraction;
    }

    public String getExpressionResult(Operation operation) {
        return secondFraction.getSign().equals(Constants.NEGATIVE_SIGN) ?
                String.format(Constants.FIRST_PATTERN, firstFraction, operation.getOperation(),
                        secondFraction, operationResult) :
                String.format(Constants.SECOND_PATTERN, firstFraction, operation.getOperation(),
                        secondFraction, operationResult);
    }

    public void add() {
        int numerator;
        int denominator;
        if (firstFraction.getDenominator() == secondFraction.getDenominator()) {
            numerator = firstFraction.getNumerator() + secondFraction.getNumerator();
            denominator = firstFraction.getDenominator();
        } else {
            numerator = (firstFraction.getNumerator() * secondFraction.getDenominator()) +
                    (secondFraction.getNumerator() * firstFraction.getDenominator());
            denominator = firstFraction.getDenominator() * secondFraction.getDenominator();
        }
        operationResult = new Fraction(numerator, denominator);
    }

    public void subtract() {
        int numerator;
        int denominator;
        if (firstFraction.getDenominator() == secondFraction.getDenominator()) {
            numerator = firstFraction.getNumerator() - secondFraction.getNumerator();
            denominator = firstFraction.getDenominator();
        } else {
            numerator = (firstFraction.getNumerator() * secondFraction.getDenominator()) -
                    (secondFraction.getNumerator() * firstFraction.getDenominator());
            denominator = firstFraction.getDenominator() * secondFraction.getDenominator();
        }
        operationResult = new Fraction(numerator, denominator);
    }

    public void multiply() {
        int numerator = firstFraction.getNumerator() * secondFraction.getNumerator();
        int denominator = firstFraction.getDenominator() * secondFraction.getDenominator();
        operationResult = new Fraction(numerator, denominator);
    }

    public void divide() {
        int numerator = firstFraction.getNumerator() * secondFraction.getDenominator();
        int denominator = firstFraction.getDenominator() * secondFraction.getNumerator();
        operationResult = new Fraction(numerator, denominator);
    }
}
