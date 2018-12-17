package net.proselyte.rnpcalculator.io;

import net.proselyte.rnpcalculator.model.ArithmeticOperator;
import net.proselyte.rnpcalculator.model.Calculator;
import net.proselyte.rnpcalculator.service.CalculatorService;
import net.proselyte.rnpcalculator.service.impl.CalculatorServiceImpl;

import java.util.Stack;

public class CalculatorConsoleController {
    private final CalculatorService calculatorService;

    public CalculatorConsoleController() {
        calculatorService = new CalculatorServiceImpl();
    }

    public Double calculateResult(Stack<Double> values, String operator, Double result) {

        if (values == null) {
            throw new UnsupportedOperationException("Values cannot be null");
        }

        if (!ArithmeticOperator.isValidIdentifier(operator)) {
            throw new UnsupportedOperationException("Not supported operator");
        }

        Calculator calculator = Calculator.builder()
                .values(values)
                .arithmeticOperator(ArithmeticOperator.getByIdentifier(operator))
                .result(result)
                .build();

        return calculatorService.calculateResult(calculator);
    }
}
