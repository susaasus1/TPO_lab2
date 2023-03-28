import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import csv.Printer;
import functions.function.TrigonometryFunctionCalculator;
import functions.logarithms.Ln;
import functions.logarithms.LogX;
import functions.logarithms.LogarithmFunction;
import functions.trigonometry.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class FunctionTest {
    private static double accuracy;
    private static final double delta = 1 / 1e3;
    private static Ln lnMock;
    private static LogX logXMock;
    private static Cos cosMock;
    private static Cot cotMock;
    private static Csc cscMock;
    private static Sec secMock;
    private static Sin sinMock;
    private static Tan tanMock;
    private static Printer csvPrinter;

    @BeforeAll
    static void init() throws IOException, CsvException {
        lnMock = mock(Ln.class);
        logXMock = mock(LogX.class);
        cosMock = mock(Cos.class);
        cotMock = mock(Cot.class);
        cscMock = mock(Csc.class);
        secMock = mock(Sec.class);
        sinMock = mock(Sin.class);
        tanMock = mock(Tan.class);

        accuracy = 1 / 1e10;
        csvPrinter = new Printer();
        String lnPath = "src/test/resources/LogarithmInput/lnInput.csv";
        CSVReader reader = new CSVReader(new FileReader(lnPath));
        List<String[]> data = reader.readAll();
        for (String[] i : data)
            Mockito.when(lnMock.calculate(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));

        String log2Path = "src/test/resources/LogarithmInput/Log2Input.csv";
        reader = new CSVReader(new FileReader(log2Path));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(logXMock.calculate(Double.parseDouble(i[0]), 2, accuracy)).thenReturn(Double.parseDouble(i[1]));

        String log3Path = "src/test/resources/LogarithmInput/Log3Input.csv";
        reader = new CSVReader(new FileReader(log3Path));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(logXMock.calculate(Double.parseDouble(i[0]), 3, accuracy)).thenReturn(Double.parseDouble(i[1]));

        String log5Path = "src/test/resources/LogarithmInput/Log5Input.csv";
        reader = new CSVReader(new FileReader(log5Path));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(logXMock.calculate(Double.parseDouble(i[0]), 5, accuracy)).thenReturn(Double.parseDouble(i[1]));

        String log10Path = "src/test/resources/LogarithmInput/Log10Input.csv";
        reader = new CSVReader(new FileReader(log10Path));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(logXMock.calculate(Double.parseDouble(i[0]), 10, accuracy)).thenReturn(Double.parseDouble(i[1]));

        String cosPath = "src/test/resources/TrigonometryInput/cos.csv";
        reader = new CSVReader(new FileReader(cosPath));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(cosMock.cos(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));

        String sinPath = "src/test/resources/TrigonometryInput/sin.csv";
        reader = new CSVReader(new FileReader(sinPath));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(sinMock.sin(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));


        String cotPath = "src/test/resources/TrigonometryInput/cot.csv";
        reader = new CSVReader(new FileReader(cotPath));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(cotMock.cot(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));

        String cscPath = "src/test/resources/TrigonometryInput/csc.csv";
        reader = new CSVReader(new FileReader(cscPath));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(cscMock.csc(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));

        String secPath = "src/test/resources/TrigonometryInput/sec.csv";
        reader = new CSVReader(new FileReader(secPath));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(secMock.sec(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));


        String tanPath = "src/test/resources/TrigonometryInput/tan.csv";
        reader = new CSVReader(new FileReader(tanPath));
        data = reader.readAll();
        for (String[] i : data)
            Mockito.when(tanMock.tan(Double.parseDouble(i[0]), accuracy)).thenReturn(Double.parseDouble(i[1]));

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testSystemWithAllMocks(double value, double expected) throws FileNotFoundException {
        Function systemFunc = new Function(new LogarithmFunction(lnMock, logXMock), new TrigonometryFunctionCalculator(cotMock, cosMock, cscMock, tanMock, secMock));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testWithSecCsc(double value, double expected) throws FileNotFoundException {
        Function systemFunc = new Function(new LogarithmFunction(lnMock, logXMock), new TrigonometryFunctionCalculator(cotMock, cosMock, new Csc(sinMock), tanMock, new Sec(cosMock)));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testWithCos(double value, double expected) throws FileNotFoundException {
        Function systemFunc = new Function(new LogarithmFunction(lnMock, logXMock), new TrigonometryFunctionCalculator(cotMock, new Cos(sinMock), new Csc(sinMock), tanMock, new Sec(cosMock)));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testWithDependencyMocks(double value, double expected) throws FileNotFoundException {
        Function systemFunc = new Function(new LogarithmFunction(lnMock, logXMock), new TrigonometryFunctionCalculator(new Cot(sinMock, cosMock), new Cos(sinMock), new Csc(sinMock), new Tan(sinMock, cosMock), new Sec(cosMock)));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testWithLogarithmsMocks(double value, double expected) throws FileNotFoundException {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        Tan tan = new Tan(sin, cos);
        Sec sec = new Sec(cos);
        Function systemFunc = new Function(new LogarithmFunction(lnMock, logXMock), new TrigonometryFunctionCalculator(cot, cos, csc, tan, sec));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testWithLog(double value, double expected) throws FileNotFoundException {
        Function systemFunc = new Function(new LogarithmFunction(lnMock, new LogX(lnMock)), new TrigonometryFunctionCalculator(cotMock, cosMock, cscMock, tanMock, secMock));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SystemInput/systemInput.csv")
    void testWithLn(double value, double expected) throws FileNotFoundException {
        Function systemFunc = new Function(new LogarithmFunction(new Ln(), new LogX(new Ln())), new TrigonometryFunctionCalculator(cotMock, cosMock, cscMock, tanMock, secMock));
        double result = systemFunc.calculate(value, accuracy);
        csvPrinter.csvPrint(value, result, "src/test/resources/SystemOutput/systemOutput.csv");
        Assertions.assertEquals(expected, result, delta);
    }

}
