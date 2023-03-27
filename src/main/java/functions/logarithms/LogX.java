package functions.logarithms;

public class LogX {
    Ln ln = new Ln();

    public LogX() {
    }

    public LogX(Ln ln) {
        this.ln = ln;
    }

    public double calculate(double number, double base, double accuracy) {
        //замена основания логарифма
        return ln.calculate(number, accuracy) / ln.calculate(base, accuracy);
    }
}
