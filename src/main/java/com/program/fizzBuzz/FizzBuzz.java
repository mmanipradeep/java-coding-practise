package com.program.fizzBuzz;

import java.util.List;
import java.util.stream.Collectors;
public class FizzBuzz {

    private final List<com.program.fizzBuzz.Divider> dividers;

    public FizzBuzz(List<com.program.fizzBuzz.Divider> dividers) {
        this.dividers = dividers;
    }

    public String getOutput(int number) {
        String dividersOutput = dividers.stream()
                .filter(divider -> divider.divides(number))
                .map(com.program.fizzBuzz.Divider::getOutput)
                .collect(Collectors.joining(""));

        if (dividersOutput.isEmpty()) {
            return number + "";
        }
        return dividersOutput;
    }

}
