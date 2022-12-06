package com.program.forkJoin.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomerDataResponse {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private LocalDate createdAt;

}
