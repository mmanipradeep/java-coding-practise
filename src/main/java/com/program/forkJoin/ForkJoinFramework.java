package com.program.forkJoin;

import com.program.forkJoin.client.CustomerDataClient;
import com.program.forkJoin.client.CustomerPurchaseTransactionClient;
import com.program.forkJoin.dto.CustomerDataResponse;
import com.program.forkJoin.dto.PurchaseTransactionResponse;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Slf4j
public class ForkJoinFramework {

    public static void main(String[] args) {

        ForkJoinFramework javaParallelProcessingUsingForkJoinFramework = new ForkJoinFramework();

        // using simple thread
        javaParallelProcessingUsingForkJoinFramework.simpleThread();

        // using Fork/Join Framework
        javaParallelProcessingUsingForkJoinFramework.usingForkJoinFramework();

    }

    private void simpleThread() {
        LocalDateTime startTime = LocalDateTime.now();
        List<Long> customerIds = LongStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
        List<CustomerWithTotalAmountSpend> customerWithTotalAmountSpendList = customerIds.stream()
                .map(this::fetchCustomerWithTotalAmountSpend)
                .collect(Collectors.toUnmodifiableList());
        log.info("Response: {} ", customerWithTotalAmountSpendList);
        log.info("Operation duration {} ", Duration.between(startTime, LocalDateTime.now()).toSeconds());
    }

    private CustomerWithTotalAmountSpend fetchCustomerWithTotalAmountSpend(Long customerId) {

        CustomerPurchaseTransactionClient customerPurchaseTransactionClient = new CustomerPurchaseTransactionClient();

        List<PurchaseTransactionResponse> purchaseTransactionResponses = customerPurchaseTransactionClient.fetchByCustomerId(
                customerId);

        log.info("Summing up transactions... ");
        BigDecimal totalAmountSpend = purchaseTransactionResponses.stream()
                .map(PurchaseTransactionResponse::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        CustomerDataClient customerDataClient = new CustomerDataClient();
        CustomerDataResponse customerDataResponse = customerDataClient.fetchCustomerById(customerId);

        return CustomerWithTotalAmountSpend.builder()
                .customerDataResponse(customerDataResponse)
                .totalAmountSpend(totalAmountSpend)
                .build();
    }

    private static void usingForkJoinFramework() {

        LocalDateTime startTime = LocalDateTime.now();
        List<Long> customerIds = LongStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());

        FetchCustomerRecursiveTask fetchCustomerRecursiveTask = new FetchCustomerRecursiveTask(customerIds);

        ForkJoinPool forkJoinCommonPool = ForkJoinPool.commonPool();

        List<CustomerWithTotalAmountSpend> customerWithTotalAmountSpendList = forkJoinCommonPool.invoke(
                fetchCustomerRecursiveTask);

        log.info("Response: {} ", customerWithTotalAmountSpendList);
        log.info("Operation duration {} ", Duration.between(startTime, LocalDateTime.now()).toSeconds());
    }
}
