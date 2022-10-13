package demo.test.executable;

import demo.test.logic.Operation;
import demo.test.logic.Substract;
import demo.test.logic.Sum;

public class Main {
    public static void main(String[] args) {
        double a = 25;
        double b =38;
        calculate(a,b);
    }

    private static void calculate(double a, double b){
        Operation sum = new Sum();
        Operation sub = new Substract();
        System.out.println("Sum and sub operation for " + a + " and " + b + ".\n");
        System.out.println("Sum: " + sum.operate(a,b) + "\nsub: " + sub.operate(a,b));
    }
}