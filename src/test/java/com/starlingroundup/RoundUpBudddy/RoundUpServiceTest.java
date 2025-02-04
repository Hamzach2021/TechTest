package com.starlingroundup.RoundUpBudddy;

import com.starlingroundup.RoundUpBudddy.model.Amount;

import com.starlingroundup.RoundUpBudddy.model.FeedItem;
import com.starlingroundup.RoundUpBudddy.model.Transactions;
import com.starlingroundup.RoundUpBudddy.service.RoundupService;
import com.starlingroundup.RoundUpBudddy.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoundUpServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private RoundupService roundupService;

    @Test
    void roundUp(){

        when(transactionService.getTransactions("123", "123")).thenReturn(Transactions.builder()
                .feedItems(List.of(
                        FeedItem.builder()
                .amount(Amount.builder()
                        .currency("GBP")
                        .minorUnits(123L)
                        .build())
                .direction("OUT")
                                .build(),
                        FeedItem.builder()
                                .amount(Amount.builder()
                                        .minorUnits(1234567L)
                                        .build())
                                .direction("OUT")
                                .build()))
                .build());

       Amount actual = roundupService.getSpendingRoundUp("123", "123");
       Amount expected = Amount.builder()
               .currency("GBP")
               .minorUnits(110L)
               .build();

        assertEquals(expected, actual);

    }
}