package com.starlingroundup.RoundUpBudddy.service;

import com.starlingroundup.RoundUpBudddy.model.Amount;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j//Wanted to use this but maven wasn't building and I had limited time
public class GoalService {

    private final RestTemplate restTemplate;
    private static final Logger logger = Logger.getLogger(GoalService.class.getName());
    private String savingsGoalUid = "27addce8-c5ee-475f-b60e-ce47556a9e5f"; //Could avoid hard coding but this was done as there's only one savings account
    private String transferUid = "280e7882-75e9-4da4-94ad-0cd159b37738";// like above
    private String accountUid = "f7bc1bbd-e015-4a2d-bf5f-0ead8ec58307";// like above


    public GoalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void saveMoney(Amount amount){

        final HttpEntity<Amount> request = this.getHeadersWithBody(amount);

        String url = "https://api-sandbox.starlingbank.com/api/v2/account/"
                + accountUid + "/savings-goals/" + savingsGoalUid + "/add-money/"
                + transferUid;

//        logger.log(INFO, "Sending: "+ amount.toString() + "to saving pot for account: " + accountUid );
        restTemplate.exchange(url, HttpMethod.PUT,request, Void.class );
//        logger.log(INFO, "Successfully sent : "+ amount + "to saving pot for account: " + accountUid );
    }
    private HttpEntity<Amount> getHeadersWithBody(Amount amount) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.ALL));
        headers.add("Authorization", "Bearer " + System.getenv("Authorization"));

        return new HttpEntity<>(amount, headers);
    }
}