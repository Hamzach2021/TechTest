package com.starlingroundup.RoundUpBudddy;

import com.starlingroundup.RoundUpBudddy.model.Amount;
import com.starlingroundup.RoundUpBudddy.model.FeedItem;
import com.starlingroundup.RoundUpBudddy.model.Transactions;
import com.starlingroundup.RoundUpBudddy.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void roundUp(){
        transactionService.getTransactions()

    }
}
