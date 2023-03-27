package functions.trigonometry;

import java.math.BigDecimal;
import java.math.MathContext;

public class Cos {
    private Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public double cos(double x, double precision) {
        double cos = Math.sqrt(1 - (sin.sin(x, precision) * sin.sin(x, precision)));
        x = Math.abs(x % (2 * Math.PI));
        if ((x > Math.PI / 2) && (x < 3 * Math.PI / 2)) {
            cos = cos * -1.0;
        }
        if (Math.abs(cos) > 1) return Double.NaN;
        return cos;
    }
}
