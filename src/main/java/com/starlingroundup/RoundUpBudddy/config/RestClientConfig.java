package com.starlingroundup.RoundUpBudddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
//****Attempt at RestClient, I would've used Rest Clent over the rest template
@Configuration
public class RestClientConfig {
//    @Bean
//    public RestClient transactionClient() {c

//        String apiKey = System.getenv("Authorization"); // Read from ENV
////        if (apiKey == null || apiKey.isEmpty()) {
////            throw new IllegalStateException("Authorization token is missing");
////        }
//
//        return RestClient.builder()
//                .baseUrl("https://api-sandbox.starlingbank.com")
//                .defaultHeader("Authorization", "Bearer " + apiKey)
//                .defaultHeader("accept", "application/json")
//                .defaultHeader("User-Agent", "Java HttpClient")
//                .defaultHeader("Accept-Encoding", "gzip, deflate, br")
//                .defaultHeader("Connection", "keep-alive")
//                .defaultHeader("Host", "api-sandbox.starlingbank.com")
//                .defaultHeader("Content-Type", "application/json")
//                .build();
//    }
}

