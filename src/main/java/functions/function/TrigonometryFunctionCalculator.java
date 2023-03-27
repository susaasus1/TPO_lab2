package functions.function;

import functions.trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TrigonometryFunctionCalculator {
    private Cot cot;
    private Cos cos;

    private Csc csc;

    private Tan tan;

    private Sec sec;

    public TrigonometryFunctionCalculator(Cot cot, Cos cos, Csc csc, Tan tan, Sec sec) {
        this.cot = cot;
        this.cos = cos;
        this.csc = csc;
        this.tan = tan;
        this.sec = sec;
    }

    public double calculate(double x, double precision) {
        return ((((((Math.pow(sec.sec(x, precision) * sec.sec(x, precision), 2)) * sec.sec(x, precision)) - (sec.sec(x, precision) + sec.sec(x, precision))) - csc.csc(x, precision)) / ((tan.tan(x, precision) + sec.sec(x, precision)) * cos.cos(x, precision))) / (((csc.csc(x, precision) - (tan.tan(x, precision) + (cot.cot(x, precision) - sec.sec(x, precision)))) - ((((cot.cot(x, precision) - csc.csc(x, precision)) * tan.tan(x, precision)) / cos.cos(x, precision)) - cot.cot(x, precision))) * (Math.pow(cos.cos(x, precision) + tan.tan(x, precision), 2))));
    }
}
