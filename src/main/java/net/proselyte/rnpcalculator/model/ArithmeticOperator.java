package net.proselyte.rnpcalculator.model;

/**
 * Enumeration that represents arithmetic operator.
 *
 * @author Euegene Suleimanov
 * @version 1.0
 */

public enum ArithmeticOperator {
    ADDITION("+"),
    SUBTRACTION("-"),
    DIVISION("/"),
    MULTIPLICATION("*"),
    MODULO("%");

    final String identifier;

    ArithmeticOperator(String identifier) {
        this.identifier = identifier;
    }

    public static ArithmeticOperator getByIdentifier(String identifier) {
        for (ArithmeticOperator operator : values()) {
            if (operator.identifier.equals(identifier)) {
                return operator;
            }
        }
        return null;
    }

    public static boolean isValidIdentifier(String identifier) {
        for (ArithmeticOperator operator : values()) {
            if (operator.identifier.equals(identifier)) {
                return true;
            }
        }
        return false;
    }
}
