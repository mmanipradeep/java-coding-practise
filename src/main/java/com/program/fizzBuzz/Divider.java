package com.program.fizzBuzz;

public class Divider {

    private final String output;

    public Divider(String output, int divisor) {
        this.output = output;
        this.divisor = divisor;
    }

    private final int divisor;

    public boolean divides(int multiple) {
        return multiple % divisor == 0;
    }

    public String getOutput() {
        return output;
    }
}
