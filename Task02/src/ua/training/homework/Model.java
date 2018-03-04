package ua.training.homework;

public class Model {
    private int targetNumber;
    private int enteredNumber;
    private String actionResult;
    private int lowerBound;
    private int upperBound;
    private int attemptNumber;
    private StringBuilder statistic = new StringBuilder();

    private static final String STATISTIC_PATTERN = "[#%2d: range: %2d - %3d | number: %3d | result: %s]%n";

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public int getEnteredNumber() {
        return enteredNumber;
    }

    public void setEnteredNumber(int enteredNumber) {
        this.enteredNumber = enteredNumber;
    }

    public String getActionResult() {
        return actionResult;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public void calculateActionResult() {
        switch (Integer.compare(targetNumber, enteredNumber)) {
            case -1:
                this.actionResult = Controller.SMALLER;
                break;
            case 1:
                this.actionResult = Controller.BIGGER;
                break;
            case 0:
                this.actionResult = Controller.SAME;
        }
    }

    public String getStatistic() {
        return statistic.toString();
    }

    public void addStatistic() {
        statistic.append(String.format(STATISTIC_PATTERN, ++attemptNumber, lowerBound, upperBound, enteredNumber, actionResult));
    }
}
