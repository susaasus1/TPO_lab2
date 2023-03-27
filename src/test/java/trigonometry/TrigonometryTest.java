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
    private static Printer csvPrinter;
    private static Cos cos;
    private static Cot cot;
    private static Csc csc;
    private static Sec sec;
    private static Sin sin;
    private static Tan tan;

    @BeforeAll
    public static void init() {
        precision = 0.0001;
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
    void sinTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = sin.sin(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(), "src/test/resources/TrigonometryOutput/sin.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/cos.csv")
    void cosTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = cos.cos(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(), "src/test/resources/TrigonometryOutput/cos.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/sec.csv")
    void secTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = sec.sec(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(), "src/test/resources/TrigonometryOutput/sec.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/csc.csv")
    void cscTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = csc.csc(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(), "src/test/resources/TrigonometryOutput/csc.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/tan.csv")
    void tanTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = tan.tan(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(), "src/test/resources/TrigonometryOutput/tan.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/cot.csv")
    void cotTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = cot.cot(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(), "src/test/resources/TrigonometryOutput/cot.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

}
