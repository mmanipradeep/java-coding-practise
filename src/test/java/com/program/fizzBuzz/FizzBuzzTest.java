package com.program.fizzBuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.program.fizzBuzz.Divider;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    List<Divider> dividers = List.of(
            new Divider("Fizz", 3),
            new Divider("Buzz", 5)
    );
    FizzBuzz fizzBuzz = new FizzBuzz(dividers);

    @ParameterizedTest
    @CsvSource(value = {
            "1:1",
            "2:2",
            "3:Fizz",
            "5:Buzz",
            "15:FizzBuzz",
            "16:16"
    }, delimiter = ':')
    void getOutput(String input, String expected) {
        int number = Integer.parseInt(input);

        assertThat(fizzBuzz.getOutput(number))
                .isEqualTo(expected);
    }
}
