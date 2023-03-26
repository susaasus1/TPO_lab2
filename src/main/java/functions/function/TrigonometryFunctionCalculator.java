package functions.function;

import functions.trigonometry.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TrigonometryFunctionCalculator {
    public static BigDecimal calculate(double x, double precision) {
        return (((((((Sec.sec(x, precision).multiply(Sec.sec(x, precision))).pow(2)).multiply(Sec.sec(x, precision))).subtract(Sec.sec(x, precision).add(Sec.sec(x, precision)))).subtract(Csc.csc(x, precision)))
                .divide((Tan.tan(x, precision).add(Sec.sec(x, precision))).multiply(Cos.cos(x, precision)), 20, RoundingMode.HALF_UP))
                .divide(((Csc.csc(x, precision).subtract(Tan.tan(x, precision).add(Cot.cot(x, precision).subtract(Sec.sec(x, precision))))).subtract((((Cot.cot(x, precision).subtract(Csc.csc(x, precision))).multiply(Tan.tan(x, precision))).divide(Cos.cos(x, precision), 20, RoundingMode.HALF_UP)).subtract(Cot.cot(x, precision)))).multiply((Cos.cos(x, precision).add(Tan.tan(x, precision))).pow(2)), 20, RoundingMode.HALF_UP));
    }
}
