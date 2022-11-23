package com.program.summaryStats;

import java.util.*;

public class SummaryStatistics {
    /**
     * The DoubleSummaryStatistics class is used to collect statistics. Information including the average, the maximum, and the minimum can be stored.
     *
     * Essentially, this can function like an array; values can be accepted into the object, which is subsequently recorded. Data and information summaries can then be extracted from these values.
     * @param args
     */

    public static void main(String[] args) {

        IntSummaryStatistics data = new IntSummaryStatistics();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> iter = nums.listIterator();
        while (iter.hasNext()){
            data.accept(iter.next());
        }
        System.out.println("Average: " + data.getAverage());
        System.out.println("Count: " + data.getCount());/*
Output:
Average: 5.5
Count: 10
*/
        DoubleSummaryStatistics name = new DoubleSummaryStatistics();

        /**
         * getAverage() — returns the average of the values recorded
         * accept() — records another value into the object
         * getCount() — returns the count of values in the object
         * getSum() — returns the sum of the values recorded
         */
        name.accept(10);
        name.accept(20);
        name.accept(30);
        System.out.println("Average: " + name.getAverage());
        System.out.println("Sum: " + name.getSum());
        System.out.println("Count: " + name.getCount());

        OptionalDouble val = OptionalDouble.empty();
        OptionalDouble val2 = OptionalDouble.of(15.0);
        System.out.println("val2 >>");
        System.out.println("A value is present: " + val2.isPresent());
        System.out.println("Double contained: " + val2.getAsDouble());
        System.out.println("Equal to 15: " + val2.equals(15.0));
        System.out.println();System.out.println("val >>");
        System.out.println("A value is present: " + val.isPresent());
        System.out.println("Double contained: " + val.getAsDouble());/*
Output:val2 >>
A value is present: true
Double contained: 15.0
Equal to 15: falseval >>
A value is present: false
NoSuchElementException
*/

/*
Output:
Average: 20.0
Sum: 60.0
Count: 3
*/
    }
}
