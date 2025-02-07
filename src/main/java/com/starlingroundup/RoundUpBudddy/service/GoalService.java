package com.starlingroundup.RoundUpBudddy.service;

import com.starlingroundup.RoundUpBudddy.model.Amount;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@Service
@Slf4j//Wanted to use this but maven wasn't building and I had limited time
public class GoalService {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(GoalService.class);
    private String savingsGoalUid = "27addce8-c5ee-475f-b60e-ce47556a9e5f";
    private String transferUid = UUID.randomUUID().toString();


    public GoalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void saveMoney(Amount amount, String accountUid){

        final HttpEntity<Map<String, Object>> request = this.getHeadersWithBody(amount);

        String url = "https://api-sandbox.starlingbank.com/api/v2/account/"
                + accountUid + "/savings-goals/" + savingsGoalUid + "/add-money/"
                + transferUid;

        logger.info("Sending: "+ amount.toString() + "to saving pot for account: " + accountUid);
        restTemplate.exchange(url, HttpMethod.PUT,request, Void.class );
        logger.info( "Successfully sent : "+ amount + "to saving pot for account: " + accountUid );
    }
    private HttpEntity<Map<String, Object>> getHeadersWithBody(Amount amount) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.ALL));
        headers.add("Authorization", "Bearer " + System.getenv("Authorization"));
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("amount", amount);

        return new HttpEntity<>(requestBody, headers);
    }
}