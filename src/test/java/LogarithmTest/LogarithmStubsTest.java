package LogarithmTest;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.logarithms.Ln;
import functions.logarithms.LogX;

import functions.logarithms.LogarithmFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
@DisplayName("Logarithm test with stubs")
public class LogarithmStubsTest {
    private static final double accuracy = 1 / 1e5;
    private static final Ln ln = Mockito.mock(Ln.class);
    private static final LogX logX = Mockito.mock(LogX.class);
    public static final LogarithmFunction logarithmFunction = new LogarithmFunction();

    @BeforeAll
    public static void initializeMocks() throws IOException, CsvException {
        String lnPath = "src/test/resources/LogarithmInput/lnInput.csv";
        CSVReader reader = new CSVReader(new FileReader(lnPath));
        List<String[]> data = reader.readAll();
        for (String[] i : data) {
            if (Double.parseDouble(i[0]) <= 0) {
                Mockito.when(ln.calculate(Double.parseDouble(i[0]), accuracy)).thenThrow(new ArithmeticException("Number должен быть больше 0!"));
            } else {
                Mockito.when(ln.calculate(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));
            }
        }
        String logPath = "src/test/resources/LogarithmInput/LogInput.csv";
        reader = new CSVReader(new FileReader(logPath));
        data = reader.readAll();
        for (String[] i : data) {
            if (Double.parseDouble(i[0]) <= 0) {
                Mockito.when(logX.calculate(Double.parseDouble(i[0]), Double.parseDouble(i[1]), accuracy)).thenThrow(new ArithmeticException("Number должен быть больше 0!"));
            } else {
                Mockito.when(logX.calculate(Double.parseDouble(i[0]), Double.parseDouble(i[1]), accuracy)).thenReturn(Double.parseDouble(i[2]));
            }
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/LogarithmInput/lnInput.csv")
    @DisplayName("Тестирование натурального логарифма заглушкой")
    void lnTest(double number, double trueAnswer) {
        try {
            Double answer = ln.calculate(number, accuracy);
            Assertions.assertEquals(trueAnswer, answer, 0.1);
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Number должен быть больше 0!", e.getMessage());
        }
    }

    @ParameterizedTest
    @DisplayName("Тестирование логарифма по основанию X с заглушкой")
    @CsvFileSource(resources = "/LogarithmInput/LogInput.csv")
    void logTest(double number, double base, double trueAnswer) {
        try {
            Double answer = logX.calculate(number, base, accuracy);
            Assertions.assertEquals(trueAnswer, answer, 0.1);
        } catch (ArithmeticException e) {
            Assertions.assertEquals("Number должен быть больше 0!", e.getMessage());
        }
    }
}