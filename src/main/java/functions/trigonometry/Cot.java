package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cot {
    public static BigDecimal cot(double x, double precision){
        return Cos.cos(x, precision).divide(Sin.sin(x, precision), 20, RoundingMode.HALF_UP);
    }
}
