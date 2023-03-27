package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cot {
    private Sin sin;
    private Cos cos;

    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public BigDecimal cot(double x, double precision) {
        if (x % Math.PI == 0)
            return new BigDecimal(Double.NaN);
        return cos.cos(x, precision).divide(sin.sin(x, precision), 20, RoundingMode.HALF_UP);
    }
}
