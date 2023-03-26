package functions;

import functions.logarithms.Ln;
import functions.logarithms.LogX;
import functions.logarithms.LogarithmFunction;

public class Main {
    public static void main(String[] args) {
        Ln ln = new Ln();
        LogX logX = new LogX();
        LogarithmFunction func2 = new LogarithmFunction(ln, logX);
        System.out.println(func2.calculate(52, 0.00001));
    }
}
