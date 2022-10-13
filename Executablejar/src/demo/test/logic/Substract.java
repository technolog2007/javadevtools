package demo.test.logic;

public class Substract implements Operation{
    @Override
    public double operate(double a, double b) {
        return (a >= b) ? a - b : b - a;
    }
}
