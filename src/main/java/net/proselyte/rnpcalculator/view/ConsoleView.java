package net.proselyte.rnpcalculator.view;

import net.proselyte.rnpcalculator.model.CalculatorIOException;

import java.io.InputStream;
import java.util.Scanner;


/**
 * Main console view class for interaction with console.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */
public class ConsoleView {

    private static final InputStream in = System.in;
    private static final CalculatorView calculatorView = new CalculatorView();

    public void runRnpCalculator() {
        Scanner scanner = new Scanner(in);

        while (scanner.hasNextLine()) {
            String line = scanner.next();

            if (line.equalsIgnoreCase("q")) {
                System.exit(0);
            }

            try {
                calculatorView.handleInput(line);
            } catch (CalculatorIOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
