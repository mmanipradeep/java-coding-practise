package com.program.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExample{

    public static void main(String[] args) {


        EmployeeRecord p11 = new EmployeeRecord("Mani", 11500,"M","IT",2010);
        EmployeeRecord p21 = new EmployeeRecord("EmployeeRecord2", 10000,"F","CSE",2022);
        EmployeeRecord p31 = new EmployeeRecord("EmployeeRecord3", 12000,"M","MECH",2000);

        List<EmployeeRecord> EmployeeRecordsRecords = Arrays.asList(p11, p21, p31);

        Optional<EmployeeRecord> min = EmployeeRecordsRecords.stream()
                .collect(Collectors.minBy(
                        Comparator.comparingInt(EmployeeRecord::salary)));
        System.out.println(min.isPresent()?min.get():"NA");


        Optional<EmployeeRecord> oldEmployeeRecord = EmployeeRecordsRecords.stream()
                .max(Comparator.comparing(EmployeeRecord::salary));

        Map<String, Long> maleAndFemaleInSaleMarketTeam = EmployeeRecordsRecords.stream()
                .filter(emp -> emp.department().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(EmployeeRecord::gender, Collectors.counting()));

        Map<String, Double> avgSalaryOfMaleAndFemale = EmployeeRecordsRecords.stream()
                //.filter(e-> e.getGender().equals("M"))
                .collect(Collectors.groupingBy(EmployeeRecord::gender,
                        Collectors.averagingDouble(EmployeeRecord::salary)));
        System.out.println(avgSalaryOfMaleAndFemale);


        EmployeeRecordsRecords.stream()
                .collect(Collectors.groupingBy(EmployeeRecord::gender,Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, Optional<EmployeeRecord>> map =
                EmployeeRecordsRecords.stream()
                        .collect(Collectors.groupingBy(EmployeeRecord::department,
                                Collectors.maxBy(Comparator.comparingInt(EmployeeRecord::salary))));
        map.entrySet().forEach(System.out::println);

//distinct EmployeeRecord
        EmployeeRecordsRecords.stream().
                map(EmployeeRecord::department)
                .distinct().forEach(System.out::println);

EmployeeRecordsRecords.stream()
        .collect(Collectors.groupingBy(EmployeeRecord::department,
                Collectors.averagingInt(EmployeeRecord::salary)));


        EmployeeRecordsRecords.stream()
                .filter(emp -> emp.yearOfJoining() > 2015)
                .map(EmployeeRecord::name)
                .forEach(System.out::println);

        Optional<EmployeeRecord> youngestEmployeeRecord = EmployeeRecordsRecords.stream()
                .filter(emp -> emp.gender().equals("M")
                        && emp.department().equals("IT"))
                .min(Comparator.comparing(EmployeeRecord::yearOfJoining));
        System.out.println(youngestEmployeeRecord);


        Optional<EmployeeRecord> mostWorkingExpEmp = EmployeeRecordsRecords.stream()
                .sorted(Comparator.comparing(EmployeeRecord::yearOfJoining)).findFirst();
        System.out.println(mostWorkingExpEmp.get());

        Map<String, List<EmployeeRecord>> EmployeeRecordsRecordsDepartmentList =
                EmployeeRecordsRecords.stream()
                .collect(Collectors.groupingBy(EmployeeRecord::department));
        Set<Map.Entry<String, List<EmployeeRecord>>> entriess =
                EmployeeRecordsRecordsDepartmentList.entrySet();
        for(Map.Entry<String, List<EmployeeRecord>> entry : entriess) {

            System.out.println("Department : "+ entry.getKey());
            System.out.println("------------------------------------");
            for(EmployeeRecord emp : entry.getValue())
            {
                System.out.println(emp.name());
            }
        }

        EmployeeRecordsRecords.stream().collect(Collectors.groupingBy(EmployeeRecord :: department))
               .forEach((k, v) -> System.out.println(k + ":#" + v));



    }
}




