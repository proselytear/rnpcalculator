package net.proselyte.rnpcalculator.service;

import net.proselyte.rnpcalculator.model.ArithmeticOperator;
import net.proselyte.rnpcalculator.model.Calculator;
import net.proselyte.rnpcalculator.service.impl.CalculatorServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    public CalculatorServiceTest() {
        this.calculatorService =  new CalculatorServiceImpl();
    }

    @Test
    public void testCalculateResultAdditionSuccess() {
        Calculator additionCalculator = getAdditionCalculator();
        Double calculationResult  = calculatorService.calculateResult(additionCalculator);

        Assert.assertEquals(calculationResult, new Double(15));
    }

    @Test
    public void testCalculateResultSubtractionSuccess() {
        Calculator additionCalculator = getSubtractionCalculator();
        Double calculationResult  = calculatorService.calculateResult(additionCalculator);

        Assert.assertEquals(calculationResult, new Double(-15));
    }

    @Test
    public void testCalculateResultDivisionSuccess() {
        Calculator additionCalculator = getDivisionCalculator();
        Double calculationResult  = calculatorService.calculateResult(additionCalculator);

        Assert.assertEquals(calculationResult, new Double(5));
    }

    @Test
    public void testCalculateResultMultiplicationSuccess() {
        Calculator additionCalculator = getMultiplicationalculator();
        Double calculationResult  = calculatorService.calculateResult(additionCalculator);

        Assert.assertEquals(calculationResult, new Double(120));
    }


    private Calculator getAdditionCalculator(){
        Stack<Double> values = new Stack<>();
        values.push(1d);
        values.push(2d);
        values.push(3d);
        values.push(4d);
        values.push(5d);

        return Calculator.builder()
                .values(values)
                .arithmeticOperator(ArithmeticOperator.ADDITION)
                .build();
    }

    private Calculator getSubtractionCalculator(){
        Stack<Double> values = new Stack<>();
        values.push(1d);
        values.push(2d);
        values.push(3d);
        values.push(4d);
        values.push(5d);

        return Calculator.builder()
                .values(values)
                .arithmeticOperator(ArithmeticOperator.SUBTRACTION)
                .build();
    }

    private Calculator getDivisionCalculator(){
        Stack<Double> values = new Stack<>();
        values.push(10d);
        values.push(2d);
        values.push(100d);

        return Calculator.builder()
                .values(values)
                .arithmeticOperator(ArithmeticOperator.DIVISION)
                .build();
    }

    private Calculator getMultiplicationalculator(){
        Stack<Double> values = new Stack<>();
        values.push(1d);
        values.push(2d);
        values.push(3d);
        values.push(4d);
        values.push(5d);

        return Calculator.builder()
                .values(values)
                .arithmeticOperator(ArithmeticOperator.MULTIPLICATION)
                .build();
    }
}
