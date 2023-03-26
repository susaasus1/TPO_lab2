import functions.function.TrigonometryFunctionCalculator;
import functions.logarithms.LogarithmFunction;

public class Function {
    private LogarithmFunction logarithmFunction;
    private TrigonometryFunctionCalculator trigonometryFunctionCalculator;

    public Function(LogarithmFunction logarithmFunction, TrigonometryFunctionCalculator trigonometryFunctionCalculator) {
        this.logarithmFunction = logarithmFunction;
        this.trigonometryFunctionCalculator = trigonometryFunctionCalculator;
    }

    public Function() {
    }

    public double calculate(double number, double accuracy) {
        if (number > 0) {
            return logarithmFunction.calculate(number, accuracy);
        } else {
            return trigonometryFunctionCalculator.calculate(number, accuracy).doubleValue();
        }
    }
}
