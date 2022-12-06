package com.program.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsSample {
    public static void main(String[] args) {
        /**
         * A Collector is a special type of reduction and a terminal operation.
         * So the collector triggers the computation of the stream.
         * What does a does is it collects the data from the Stream that is connected
         * to a source into a specified Collection object
         */
        Stream<String> nameStream = Stream.of("NAME1", "NAME2", "NAME3",
                "NAME4", "NAME5", "NAME6",
                "NAME7", "NAME8", "NAME9",
                "", "", "               ");
        List<String> names = nameStream
                .map(String::trim)
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toList()); // returns immutable Object


        Map<String, Integer> map = nameStream.
                map(String::trim)
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length));

        List<String> names1 = nameStream
                .map(s -> s.trim())
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));

        Set<String> nameSet = nameStream
                .map(String::trim)
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toCollection(TreeSet::new));

        String s = Stream.of("one", "two", "three").
                map(String::trim)
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.joining(", "));
        System.out.println(s);

//        List<Employee> employees = List.of(
//                new Employee(1, "EMP1", Employee.Sex.FEMALE, 900.0),
//                new Employee(2, "EMP2", Employee.Sex.MALE, 1290.0),
//                new Employee(3, "EMP3", Employee.Sex.FEMALE, 1200.0),
//                new Employee(4, "EMP4", Employee.Sex.MALE, 900.0),
//                new Employee(5, "EMP5", Employee.Sex.FEMALE, 1290.0)
//        );
//
//        Map<Boolean, List<Employee>> greater1000Partition =
//                employees.stream().collect(
//                        Collectors.partitioningBy(emp -> emp.getSalary() > 1000));
//        1. Collectors.toList()
//        2. Collectors.toSet()
//        Collectors.toMap()
//        Collectors.toCollection():
//        Collectors.joining()
//        Collectors.partitioningBy()
//        Collectors.groupingBy()
//        8. Collectors.mapping()
//        9. Collectors.counting()
//        10. Collectors.collectingAndThen()
    }
}
