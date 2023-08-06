package com.practise.code;

public class SimpleCalculator {
	
    public static double divideNumbers(double dividend, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return dividend / divisor;
    }

}
