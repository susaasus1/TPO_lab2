package functions.trigonometry;

import java.math.BigDecimal;
import java.math.MathContext;

public class Cos {
    private Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public BigDecimal cos(double x, double precision) {
        BigDecimal cos = (BigDecimal.ONE.subtract(sin.sin(x, precision).pow(2))).sqrt(MathContext.DECIMAL128);
        x = Math.abs(x % (2 * Math.PI));
        if ((x > Math.PI / 2) && (x < 3 * Math.PI / 2)) {
            cos = cos.multiply(BigDecimal.ONE.negate());
        }
        return cos;
    }
}
