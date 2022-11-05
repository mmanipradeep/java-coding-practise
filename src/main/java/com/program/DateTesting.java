package com.program;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Set;

public class DateTesting {

    public static void main(String[] args) {
        LocalDate startDate =  LocalDate.now();
        LocalDate endDate =LocalDate.of(2022, 12, 15);
        Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        final long weekDaysBetween = startDate.datesUntil(endDate)
                .filter(d -> !weekend.contains(d.getDayOfWeek()))
                .count()+1;
        System.out.println(weekDaysBetween);
    }
}
