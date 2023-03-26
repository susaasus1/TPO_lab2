package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sec {
    public static BigDecimal sec(double x, double precision) {
        return BigDecimal.ONE.divide(Cos.cos(x, precision), 20, RoundingMode.HALF_UP);
    }
}
