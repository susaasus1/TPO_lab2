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
    private final double accuracy = 1 / 1e5;
    private final Ln ln = new Ln();
    private final LogX logX = new LogX();
    private final Printer printer = new Printer();

    @ParameterizedTest
    @DisplayName("Тестирование натурального логарифма")
    @CsvFileSource(resources = "/LogarithmInput/lnInput.csv")
    void lnTest(double number, double trueAnswer) throws FileNotFoundException {
        try {
            Double answer = ln.calculate(number, accuracy);
            printer.csvPrint(number, answer, "src/test/resources/LogarithmOutput/lnOutput.csv");
            Assertions.assertEquals(trueAnswer, answer, 0.1);
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Number должен быть больше 0!", e.getMessage());
        }
    }

    @ParameterizedTest
    @DisplayName("Тестирование логарифма по основанию X")
    @CsvFileSource(resources = "/LogarithmInput/LogInput.csv")
    void logTest(double number, double base, double trueAnswer) throws FileNotFoundException {
        try {
            Double answer = logX.calculate(number, base, accuracy);
            printer.csvPrint(number, answer, "src/test/resources/LogarithmOutput/logOutput.csv");
            Assertions.assertEquals(trueAnswer, answer, 0.1);
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Number должен быть больше 0!", e.getMessage());
        }
    }
}
