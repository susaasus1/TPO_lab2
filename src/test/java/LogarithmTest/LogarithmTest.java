package LogarithmTest;

import csv.Printer;
import functions.logarithms.Ln;
import functions.logarithms.LogX;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LogarithmTest {
    private final double accuracy = 1 / 1e5;
    private Ln ln = new Ln();
    private LogX logX = new LogX();
    private Printer printer = new Printer();

    @ParameterizedTest
    @DisplayName("Тестирование натурального логарифма")
    @CsvFileSource(resources = "/file.csv")
    void lnTest(double number, double trueAnswer) {
        try {
            Double answer = ln.calculate(number, accuracy);
            printer.csvPrint(number,answer,"");
        }
    }
}
