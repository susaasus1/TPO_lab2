package functions.logarithms;

import static java.lang.Double.NaN;

public class Ln {
    public Ln() {
    }

    public double calculate(double number, double accuracy) throws ArithmeticException {
        //Ряд Меркатора
        if (number <= 0 || Double.isNaN(number)) return NaN;
        double answer = 0;
        final double MULTIPLIER = Math.pow(number - 1, 2) / Math.pow(number + 1, 2);
        double value = (number - 1) / (number + 1);
        long step = 1;
        while (Math.abs(value) > accuracy / 10e4) {
            answer += value;
            value = MULTIPLIER * value * (2 * step - 1) / (2 * step + 1);
            step++;
        }
        answer = answer * 2;
        return answer;
    }
}
