package com.program.forkJoin;

import com.program.forkJoin.dto.CustomerDataResponse;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CustomerWithTotalAmountSpend {
    private CustomerDataResponse customerDataResponse;
    private BigDecimal totalAmountSpend;
}
