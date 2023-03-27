package functions.trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sec {
    private Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double sec(double x, double precision) {
        if ((x - Math.PI / 2) % Math.PI != 0)
            return 1 / (cos.cos(x, precision));
        else return Double.NaN;
    }
}
