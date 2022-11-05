package com.program.streams;

public record EmployeeRecord(String name, Integer salary, String gender,
                             String department, Integer yearOfJoining) {

    public EmployeeRecord {
        if (yearOfJoining < 0)
            throw new IllegalArgumentException("employee id can't be negative");

        if (salary < 0)
            throw new IllegalArgumentException("employee salary can't be negative");
    }
}

