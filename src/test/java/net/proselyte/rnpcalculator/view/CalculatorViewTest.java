package net.proselyte.rnpcalculator.view;

import net.proselyte.rnpcalculator.model.CalculatorIOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

public class CalculatorViewTest {
    private CalculatorView calculatorView;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    public CalculatorViewTest() {
        calculatorView = new CalculatorView();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void handleInputSuccessTest() throws CalculatorIOException {
        Stack<Double> values = new Stack<>();
        values.push(1d);
        values.push(2d);
        calculatorView.setValues(values);
        calculatorView.handleInput("+");
        Assert.assertEquals(new Double(3.0), (Double) Double.parseDouble(outContent.toString()));
    }

    @Test(expected = CalculatorIOException.class)
    public void handleInputNotValidOperatorTest() throws CalculatorIOException {
        Stack<Double> values = new Stack<>();
        values.push(1d);
        values.push(2d);
        calculatorView.setValues(values);
        calculatorView.handleInput("WRONG_OPERATOR_IDENTIFIER");
    }

    @Test(expected = CalculatorIOException.class)
    public void handleInputEmptyValuesStackTest() throws CalculatorIOException {
        Stack<Double> values = new Stack<>();
        calculatorView.setValues(values);
        calculatorView.handleInput("+");
    }
}
