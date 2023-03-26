package trigonometry;

import csv.Printer;
import functions.trigonometry.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometryTest {
    private final double precision = 0.0001;
    private final Printer csvPrinter = new Printer();

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_input/sin.csv")
    void sinTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = Sin.sin(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(),"src/test/resources/trigonometry_output/sin.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_input/cos.csv")
    void cosTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = Cos.cos(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(),"src/test/resources/trigonometry_output/cos.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_input/sec.csv")
    void secTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = Sec.sec(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(),"src/test/resources/trigonometry_output/sec.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_input/csc.csv")
    void cscTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = Csc.csc(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(),"src/test/resources/trigonometry_output/csc.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_input/tan.csv")
    void tanTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = Tan.tan(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(),"src/test/resources/trigonometry_output/tan.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_input/cot.csv")
    void cotTest(Double x, BigDecimal expected) throws FileNotFoundException {
        BigDecimal result = Cot.cot(x, precision);
        csvPrinter.csvPrint(x, result.doubleValue(),"src/test/resources/trigonometry_output/cot.csv");
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

}
