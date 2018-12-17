package net.proselyte.rnpcalculator.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.rnpcalculator.model.Calculator;
import net.proselyte.rnpcalculator.service.CalculatorService;


@Slf4j
public class CalculatorServiceImpl implements CalculatorService {
    public Double calculateResult(Calculator calculator) {
        Double result = calculator.getResult() == null ? 0d : calculator.getResult();
        switch (calculator.getArithmeticOperator()) {
            case ADDITION:
                while (!calculator.getValues().empty()) {
                    result += calculator.getValues().pop();
                }
                return result;
            case DIVISION:
                result = calculator.getValues().pop();
                while (!calculator.getValues().empty()) {
                    result = result / calculator.getValues().pop();
                }
                return result;
            case SUBTRACTION:
                while (!calculator.getValues().empty()) {
                    result -= calculator.getValues().pop();
                }
                return result;
            case MULTIPLICATION:
                result = calculator.getValues().pop();
                while (!calculator.getValues().empty()) {
                    result *= calculator.getValues().pop();
                }
                return result;

            case MODULO:
                result = calculator.getValues().pop();
                while (!calculator.getValues().empty()) {
                    result %= calculator.getValues().pop();
                    System.out.println(result);
                }
                return result;
            default:
                throw new UnsupportedOperationException("Unsupported operator");
        }
    }
}
