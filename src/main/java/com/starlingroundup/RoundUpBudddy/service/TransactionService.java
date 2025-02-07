package com.starlingroundup.RoundUpBudddy.service;

import com.starlingroundup.RoundUpBudddy.model.Transactions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionService {
    private final RestTemplate restTemplate;


    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Transactions getTransactions(String accountUid, String categoryUid) {

        final HttpEntity<Transactions> request = this.getHeaders();

        return restTemplate.exchange("https://api-sandbox.starlingbank.com/api/v2/feed/account/"
                        + accountUid + "/category/" + categoryUid + "?changesSince="
                        + Instant.now().minus(7, ChronoUnit.DAYS)
                +"&Bearer" + System.getenv("Authorization")
                ,HttpMethod.GET,request, new ParameterizedTypeReference<Transactions>(){}).getBody();
    }

    private HttpEntity<Transactions> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + System.getenv("Authorization"));
        return new HttpEntity<>(headers);
    }
}
