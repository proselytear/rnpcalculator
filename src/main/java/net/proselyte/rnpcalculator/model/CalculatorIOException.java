package net.proselyte.rnpcalculator.model;

import java.io.IOException;

/**
 * Exception for Calculator input/output errors handling.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public class CalculatorIOException extends IOException {
    public CalculatorIOException(String message) {
        super(message);
    }
}