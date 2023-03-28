package LogarithmTest;

import csv.Printer;
import functions.logarithms.Ln;
import functions.logarithms.LogX;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileNotFoundException;

@DisplayName("Logarithm test")
public class LogarithmTest {
    private final double accuracy = 1 / 1e9;
    private final double delta = 1 / 1e5;
    private final Ln ln = new Ln();
    private final LogX logX = new LogX();
    private final Printer printer = new Printer();

    @ParameterizedTest
    @DisplayName("Тестирование натурального логарифма")
    @CsvFileSource(resources = "/LogarithmInput/lnInput.csv")
    void lnTest(double number, double trueAnswer) throws FileNotFoundException {
        double answer = ln.calculate(number, accuracy);
        printer.csvPrint(number, answer, "src/test/resources/LogarithmOutput/lnOutput.csv");
        Assertions.assertEquals(trueAnswer, answer, delta);
    }

    @ParameterizedTest
    @DisplayName("Тестирование логарифма по основанию 2")
    @CsvFileSource(resources = "/LogarithmInput/Log2Input.csv")
    void log2Test(double number, double trueAnswer) throws FileNotFoundException {
        double answer = logX.calculate(number, 2, accuracy);
        printer.csvPrint(number, 2, answer, "src/test/resources/LogarithmOutput/log2Output.csv");
        Assertions.assertEquals(trueAnswer, answer, delta);
    }

    @ParameterizedTest
    @DisplayName("Тестирование логарифма по основанию 3")
    @CsvFileSource(resources = "/LogarithmInput/Log3Input.csv")
    void log3Test(double number, double trueAnswer) throws FileNotFoundException {
        double answer = logX.calculate(number, 3, accuracy);
        printer.csvPrint(number, 3, answer, "src/test/resources/LogarithmOutput/log3Output.csv");
        Assertions.assertEquals(trueAnswer, answer, delta);
    }

    @ParameterizedTest
    @DisplayName("Тестирование логарифма по основанию 5")
    @CsvFileSource(resources = "/LogarithmInput/Log5Input.csv")
    void log5Test(double number, double trueAnswer) throws FileNotFoundException {
        double answer = logX.calculate(number, 5, accuracy);
        printer.csvPrint(number, 5, answer, "src/test/resources/LogarithmOutput/log5Output.csv");
        Assertions.assertEquals(trueAnswer, answer, delta);
    }

    @ParameterizedTest
    @DisplayName("Тестирование логарифма по основанию 10")
    @CsvFileSource(resources = "/LogarithmInput/Log10Input.csv")
    void log10Test(double number, double trueAnswer) throws FileNotFoundException {
        double answer = logX.calculate(number, 10, accuracy);
        printer.csvPrint(number, 10, answer, "src/test/resources/LogarithmOutput/log10Output.csv");
        Assertions.assertEquals(trueAnswer, answer, delta);
    }
}
