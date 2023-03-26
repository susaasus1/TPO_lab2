package functions.logarithms;

public class Ln {
    public Ln() {
    }

    public double calculate(double number, double accuracy) throws ArithmeticException {
        //Ряд Меркатора
        if (number <= 0 || Double.isNaN(number)) throw new ArithmeticException("Number должен быть больше 0!");
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
