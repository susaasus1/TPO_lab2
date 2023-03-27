package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Csc {
    private Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x, double precision) {
        if (x % Math.PI == 0)
            return Double.NaN;
        return 1/ (sin.sin(x, precision));
    }
}
