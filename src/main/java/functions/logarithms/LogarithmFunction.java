package functions.logarithms;

public class LogarithmFunction {
    Ln ln;
    LogX logX;

    public LogarithmFunction() {
    }

    public LogarithmFunction(Ln ln, LogX logX) {
        this.ln = ln;
        this.logX = logX;
    }

    public double calculate(double number, double accuracy) {
        return Math.pow(((ln.calculate(number, accuracy) + logX.calculate(number, 3, accuracy)) * logX.calculate(number, 3, accuracy)
                / logX.calculate(number, 5, accuracy)) + ((logX.calculate(number, 2, accuracy) - logX.calculate(number, 3, accuracy))
                * logX.calculate(number, 10, accuracy)), 2);
    }
}
