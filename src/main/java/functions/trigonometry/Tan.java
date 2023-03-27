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

    public double tan(double x, double precision) {
        if ((x - Math.PI / 2) % Math.PI != 0)
            return sin.sin(x, precision)/(cos.cos(x, precision));
        else return Double.NaN;
    }
}
