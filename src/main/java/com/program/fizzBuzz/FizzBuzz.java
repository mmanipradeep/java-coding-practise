package com.program.fizzBuzz;

import java.util.List;
import java.util.stream.Collectors;
import com.program.fizzBuzz.Divider;

public class FizzBuzz {

    private final List<Divider> dividers;

    public FizzBuzz(List<Divider> dividers) {
        this.dividers = dividers;
    }

    public String getOutput(int number) {
        String dividersOutput = dividers.stream()
                .filter(divider -> divider.divides(number))
                .map(Divider::getOutput)
                .collect(Collectors.joining(""));

        if (dividersOutput.isEmpty()) {
            return number + "";
        }
        return dividersOutput;
    }

}
