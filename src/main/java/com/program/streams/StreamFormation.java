package com.program.streams;

import java.util.stream.Stream;

public class StreamFormation {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4);
        stream.forEach(p -> System.out.println(p));
    }
}
