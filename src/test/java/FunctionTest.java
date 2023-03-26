import functions.function.TrigonometryFunctionCalculator;
import functions.logarithms.Ln;
import functions.logarithms.LogX;
import functions.logarithms.LogarithmFunction;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

public class FunctionTest {
    private static final double accuracy = 1 / 1e5;
    private static Ln lnMock;
    private static LogX logXMock;
    private static LogarithmFunction logarithmFunctionMock;
    private static TrigonometryFunctionCalculator trigonometryFunctionCalculatorMock;

    @BeforeAll
    static void init() {
        lnMock = Mockito.mock(Ln.class);
        logXMock = Mockito.mock(LogX.class);
        logarithmFunctionMock = Mockito.mock(LogarithmFunction.class);
        trigonometryFunctionCalculatorMock = Mockito.mock(TrigonometryFunctionCalculator.class);
    }

}
