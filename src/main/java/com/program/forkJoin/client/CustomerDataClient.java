package com.program.forkJoin.client;

import com.github.javafaker.Faker;
import com.program.forkJoin.dto.CustomerDataResponse;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class CustomerDataClient {

    private static final List<CustomerDataResponse> allCustomers;

    static{
        Faker faker = new Faker();

        allCustomers = LongStream.rangeClosed(1,10)
                .mapToObj(i -> CustomerDataResponse.builder()
                        .id(i)
                        .createdAt(
                                LocalDate.now().minus(Period.ofDays((new Random().nextInt(365*10)))))
                        .fullName(faker.name().fullName())
                        .phoneNumber(faker.phoneNumber().cellPhone())
                        .address(faker.address().fullAddress())
                        .build()).collect(toList());

    }

    public CustomerDataResponse fetchCustomerById ( Long customerId){
        log.info("Getting customer By Id ");
        return allCustomers.stream().filter(customer -> customer.getId().equals(customerId))
                .findAny().orElseThrow();

    }
}
