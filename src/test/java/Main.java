import functions.function.TrigonometryFunctionCalculator;
import functions.logarithms.Ln;
import functions.logarithms.LogX;
import functions.logarithms.LogarithmFunction;
import functions.trigonometry.*;

public class Main {
    public static void main(String[] args) {
        Ln ln = new Ln();
        LogX logX = new LogX();
        double acc = 1 / 1e9;
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        Tan tan = new Tan(sin, cos);
        Sec sec = new Sec(cos);
        Function systemFunc = new Function(new LogarithmFunction(new Ln(), new LogX(new Ln())), new TrigonometryFunctionCalculator(cot, cos, csc, tan, sec));
        System.out.println(systemFunc.calculate(2,acc));

    }
}
