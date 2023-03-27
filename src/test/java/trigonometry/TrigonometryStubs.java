package trigonometry;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import functions.trigonometry.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonometryStubs {
    private static Double precision;
    private static Cos cos;
    private static Cot cot;
    private static Csc csc;
    private static Sec sec;
    private static Sin sin;
    private static Tan tan;

    private static void getCosMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/TrigonometryInput/cos.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.cos.cos(Double.parseDouble(record[0]), precision)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getCotMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/TrigonometryInput/cot.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.cot.cot(Double.parseDouble(record[0]), precision)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getCscMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/TrigonometryInput/csc.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.csc.csc(Double.parseDouble(record[0]), precision)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getSecMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/TrigonometryInput/sec.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.sec.sec(Double.parseDouble(record[0]), precision)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getSinMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/TrigonometryInput/sin.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.sin.sin(Double.parseDouble(record[0]), precision)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    private static void getTanMockDataFromCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/TrigonometryInput/tan.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                when(TrigonometryStubs.tan.tan(Double.parseDouble(record[0]), precision)).thenReturn(BigDecimal.valueOf(Double.parseDouble(record[1])));
            }
        }
    }

    @BeforeAll
    public static void init() throws IOException, CsvException {
        precision = 0.0001;
        cos = mock(Cos.class);
        cot = mock(Cot.class);
        csc = mock(Csc.class);
        sec = mock(Sec.class);
        sin = mock(Sin.class);
        tan = mock(Tan.class);

        getSinMockDataFromCsv();
        getCosMockDataFromCsv();
        getCscMockDataFromCsv();
        getSecMockDataFromCsv();
        getCotMockDataFromCsv();
        getTanMockDataFromCsv();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/sin.csv")
    void sinTest(Double x, BigDecimal expected) {
        BigDecimal result = sin.sin(x, precision);
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/cos.csv")
    void cosTest(Double x, BigDecimal expected) {
        BigDecimal result = cos.cos(x, precision);
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/csc.csv")
    void cscTest(Double x, BigDecimal expected) {
        BigDecimal result = csc.csc(x, precision);
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/sec.csv")
    void secTest(Double x, BigDecimal expected) {
        BigDecimal result = sec.sec(x, precision);
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/cot.csv")
    void cotTest(Double x, BigDecimal expected) {
        BigDecimal result = cot.cot(x, precision);
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/TrigonometryInput/tan.csv")
    void tanTest(Double x, BigDecimal expected) {
        BigDecimal result = tan.tan(x, precision);
        assertEquals(expected.floatValue(), result.floatValue(), precision);
    }

}
