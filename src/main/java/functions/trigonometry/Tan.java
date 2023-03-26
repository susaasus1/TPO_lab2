package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tan {
    public static BigDecimal tan(double x, double precision) {
       return Sin.sin(x, precision).divide(Cos.cos(x, precision), 20, RoundingMode.HALF_UP);
    }
}
