package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sec {
    private Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public BigDecimal sec(double x, double precision) {
        if ((x - Math.PI / 2) % Math.PI != 0)
            return BigDecimal.ONE.divide(cos.cos(x, precision), 20, RoundingMode.HALF_UP);
        else return new BigDecimal(Double.NaN);
    }
}
