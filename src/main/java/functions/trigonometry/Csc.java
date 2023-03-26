package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Csc {
    private Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public BigDecimal csc(double x, double precision) {
        return BigDecimal.ONE.divide(sin.sin(x, precision), 20, RoundingMode.HALF_UP);
    }
}
