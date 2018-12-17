package net.proselyte.rnpcalculator.model;

import lombok.Builder;
import lombok.Data;

import java.util.Stack;


/**
 * Domain object that represents calculator.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Data
@Builder
public class Calculator {
    private Stack<Double> values;
    private ArithmeticOperator arithmeticOperator;
    private Double result = 0d;
}
