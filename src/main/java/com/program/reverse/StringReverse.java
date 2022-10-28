package com.program.reverse;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringReverse {

    public String AlphanumbericReverse(String input) {
        String result = Pattern.compile("\\d+")
                .matcher(input)
                .replaceAll(m -> new StringBuilder(m.group()).reverse().toString());
        return result;
    }

    public  String StringReverse(String string) {
        return Stream.of(string)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }
}
