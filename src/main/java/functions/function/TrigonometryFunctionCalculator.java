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

    public BigDecimal calculate(double x, double precision) {
        return (((((((sec.sec(x, precision).multiply(sec.sec(x, precision))).pow(2)).multiply(sec.sec(x, precision))).subtract(sec.sec(x, precision).add(sec.sec(x, precision)))).subtract(csc.csc(x, precision)))
                .divide((tan.tan(x, precision).add(sec.sec(x, precision))).multiply(cos.cos(x, precision)), 20, RoundingMode.HALF_UP))
                .divide(((csc.csc(x, precision).subtract(tan.tan(x, precision).add(cot.cot(x, precision).subtract(sec.sec(x, precision))))).subtract((((cot.cot(x, precision).subtract(csc.csc(x, precision))).multiply(tan.tan(x, precision))).divide(cos.cos(x, precision), 20, RoundingMode.HALF_UP)).subtract(cot.cot(x, precision)))).multiply((cos.cos(x, precision).add(tan.tan(x, precision))).pow(2)), 20, RoundingMode.HALF_UP));
    }
}
