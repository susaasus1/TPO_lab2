package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Csc {
    public static BigDecimal csc(double x, double precision) {
        return BigDecimal.ONE.divide(Sin.sin(x, precision), 20, RoundingMode.HALF_UP);
    }
}
