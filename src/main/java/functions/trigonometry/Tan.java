package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tan {
    private Sin sin;
    private Cos cos;

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public BigDecimal tan(double x, double precision) {
        return sin.sin(x, precision).divide(cos.cos(x, precision), 20, RoundingMode.HALF_UP);
    }
}
