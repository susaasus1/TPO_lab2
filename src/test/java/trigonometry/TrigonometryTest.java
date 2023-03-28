package trigonometry;

import csv.Printer;
import functions.trigonometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometryTest {
    private static double precision;
    private static double delta;
    private static Printer csvPrinter;
    private static Cos cos;
    private static Cot cot;
    private static Csc csc;
    private static Sec sec;
    private static Sin sin;
    private static Tan tan;

    @BeforeAll
    public static void init() {
        precision = 1 / 1e9;
        delta = 1 / 1e3;
        sin = new Sin();
        cos = new Cos(sin);
        tan = new Tan(sin, cos);
        csc = new Csc(sin);
        cot = new Cot(sin, cos);
        sec = new Sec(cos);
        csvPrinter = new Printer();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/sin.csv")
    void sinTest(double x, double expected) throws FileNotFoundException {
        double result = sin.sin(x, precision);
        csvPrinter.csvPrint(x, result, "src/test/resources/TrigonometryOutput/sin.csv");
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/cos.csv")
    void cosTest(double x, double expected) throws FileNotFoundException {
        double result = cos.cos(x, precision);
        csvPrinter.csvPrint(x, result, "src/test/resources/TrigonometryOutput/cos.csv");
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/sec.csv")
    void secTest(double x, double expected) throws FileNotFoundException {
        double result = sec.sec(x, precision);
        csvPrinter.csvPrint(x, result, "src/test/resources/TrigonometryOutput/sec.csv");
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/csc.csv")
    void cscTest(double x, double expected) throws FileNotFoundException {
        double result = csc.csc(x, precision);
        csvPrinter.csvPrint(x, result, "src/test/resources/TrigonometryOutput/csc.csv");
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/tan.csv")
    void tanTest(double x, double expected) throws FileNotFoundException {
        double result = tan.tan(x, precision);
        csvPrinter.csvPrint(x, result, "src/test/resources/TrigonometryOutput/tan.csv");
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/cot.csv")
    void cotTest(double x, double expected) throws FileNotFoundException {
        double result = cot.cot(x, precision);
        csvPrinter.csvPrint(x, result, "src/test/resources/TrigonometryOutput/cot.csv");
        assertEquals(expected, result, delta);
    }

}
