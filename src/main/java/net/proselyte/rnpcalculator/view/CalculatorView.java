package net.proselyte.rnpcalculator.view;

import lombok.Data;
import net.proselyte.rnpcalculator.io.CalculatorConsoleController;
import net.proselyte.rnpcalculator.model.ArithmeticOperator;
import net.proselyte.rnpcalculator.model.CalculatorIOException;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * View class for console input/output for {@link net.proselyte.rnpcalculator.model.Calculator} class.
 *
 * @author Eugene Suleimanov
 * @version 1/0
 */

@Data
class CalculatorView {
    private final CalculatorConsoleController calculatorConsoleController;
    private Stack<Double> values;
    private Double globalResult;

    CalculatorView() {
        calculatorConsoleController = new CalculatorConsoleController();
        values = new Stack<>();
        globalResult = 0d;
    }

    /**
     * Handles input for calculator.
     */
    void handleInput(String input) throws CalculatorIOException {
        if (!isValidInput(input)) {
            throw new CalculatorIOException("Invalid input. Please, try again");
        }

        if (StringUtils.isNumeric(input) || isNegativeNumber(input)) {
            values.push(Double.parseDouble(input));
        }

        if(values.isEmpty()){
            throw new CalculatorIOException("Values stack is empty. Please, enter values");
        }

        if (isValidOperator(input)) {
            Double result = calculateResult(values, input, globalResult);
            System.out.println(result);
            globalResult = result;
        }
    }

    private Double calculateResult(Stack<Double> values, String operator, Double result) {
        return calculatorConsoleController.calculateResult(values, operator, result);
    }

    /**
     * Handles negative numbers - implemented due to StringUtils class issue.
     */
    private boolean isNegativeNumber(String line) {
        if (line.length() < 2) {
            return false;
        }

        char firstElement = line.charAt(0);
        String value = line.substring(1, line.length());
        return firstElement == '-' && StringUtils.isNumeric(value);

    }

    private boolean isValidInput(String input) {
        return StringUtils.isNumeric(input) || this.isValidOperator(input) || isNegativeNumber(input);
    }

    private boolean isValidOperator(String input) {
        return ArithmeticOperator.isValidIdentifier(input);
    }
}
