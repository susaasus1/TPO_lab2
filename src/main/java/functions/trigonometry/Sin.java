package functions.trigonometry;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Sin {
    public static BigDecimal sin(double x, double precision) {
        BigDecimal decimalX = new BigDecimal(x);
        BigDecimal term = decimalX;
        BigDecimal sum = decimalX;
        BigDecimal sign = BigDecimal.ONE.negate();
        int i = 1;
        while (precision < term.abs().doubleValue()) {
            term = decimalX.pow(2 * i + 1).divide(new BigDecimal(factorial(2 * i + 1)), 20, RoundingMode.HALF_UP);
            sum = sum.add(term.multiply(sign));
            sign = sign.negate();
            i++;
        }
        return sum;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
