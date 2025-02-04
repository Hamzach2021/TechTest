package com.starlingroundup.RoundUpBudddy.service;

import com.starlingroundup.RoundUpBudddy.RoundUpBudddyApplication;
import com.starlingroundup.RoundUpBudddy.config.RestClientConfig;
import com.starlingroundup.RoundUpBudddy.model.Amount;
import com.starlingroundup.RoundUpBudddy.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

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


    //**ATTEMPT AT RUNNING JAVA REST CLIENT,
    // I would've used Rest client as Rest template is quite outdated(not deprecated its feature complete)
    //Due to limited time I have rushed the overall attempt



//    private final RestClient transactionClient;

//    public TransactionService() {
//        transactionClient = RestClient.builder()
//                .baseUrl( "https://api-sandbox.starlingbank.com")
//                .defaultHeader("Authorization", "Bearer " + System.getenv("Authorization"))
//                .defaultHeader("accept", "application/json")
//                .defaultHeader("User-Agent", "Hamza Tariq")
//                .defaultHeader("Accept-Encoding", "gzip, deflate, br")
//                .defaultHeader("Connection", "keep-alive")
//                .build();
//    }
//
//    public String getTransactions(String accountUid, String categoryUid) {
//        return transactionClient
//                .get()
//                .uri("https://api-sandbox.starlingbank.com/api/v2/feed/account/{accountUid}/category/{categoryUid}", accountUid, categoryUid)
//                .retrieve()
//                .body(String.class);
//    }
//    public ResponseEntity<List<Transaction>>getTransactions() {
//
//        String token = System.getenv("Authorization");
//        if (token == null || token.isEmpty()) {
//            throw new IllegalStateException("Authorization token is missing");
//        }
//        String result = transactionClient
//                .get()
//                .retrieve()
//                .body(String.class);
//        return null;
//    }
//    public ResponseEntity<String> getTransactions() {
//        // Create a RestTemplate instance
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Define the URL with placeholders
//        String url =  "https://api-sandbox.starlingbank.com/api/v2/feed/account/f7bc1bbd-e015-4a2d-bf5f-0ead8ec58307/category/" +
//                "f7bc03eb-ea9b-4f5a-8dea-cd33f8643b6b";
//
//        // Create a map with the placeholders' values
//        Map<String, String> params = new HashMap<>();
//        params.put("Authorization", "Bearer eyJhbGciOiJQUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAA_21TQZKjMAz8yhTn0RQYAiG3ue0H9gFClhPXgE3ZJrNTW_v3NTGEkEpOdLfUkizlb6a9z04ZjhokD_bDB3S9NucOzdcH2SF7z_zUxQjVdBR_OeQqP0IllABEboGaVtWdOFLb1TGY_4zZqWjKY1lXZVO-ZxpDIkTTtDOBRHYy4ZftJbvfWi7eXEfHUtQKKuoqOB7yA8hCNEUrxEGKLnoH-8UmZRSFKHNuW1BFWUCVqxqOlSiBi4q7InKqbWJGHOuTiL3f6tQ11UBddK8oDtIJFCBl1VQil5VSYh6Y7Mjzo6RO4XJrFQwOfHKM8u1JCD_jk6Alm6CVZrfne-3DjlmAlC42eWKpwx0kJQSky8D3yA1_Ox34DadwsU77uDLQRuqrlhP2KbjDHg0trRE6CWRNcLZPhWZm0axR2g0YtDVgFajJyKUBmnywwzoHD6iX7AGNxMAnyT3HPlZ4Cxs4YER4oghnccW3zBF_mFcpgcUkgS0I9IDnxTNp2ycEh8YjzT3faegtxek370SAnZ_hmV2ynFW6X0ul2jvqFuWYWI9hB_xeSvvweI2r8HC2Wx87bhl1x918Hpk0nIrP_sJiE194bWIypQvLqWcJceztjDyHEAecxgWOuJ5J_P_HK4rHZJ18KL9n17p79kU-2G9z5wPPDQD56zM1SpWox53eVvG85Ozff2y57guyBAAA.Zxdr6xueJ2fteSJv8_noKXQzP2LrKmUrfaJaRE7o8YcW6boRqVRB1KUFuFfBQXtJQ_o0Ew1ClGbbgZ5KIrXNQfPfPcHPpYI2WnoOq8pvepxIMd-9cRXbmw4fuLbgmsIkftWoYNoiZMdio9iN7bL5K-Beq5UY4-vEjBjCocHpuzChCVMc8CE2BnZD-c4FfIeXbgIFbVlCQfqR8DeIrxMJ2yhrkaTfmxo0CQHZWEVaeSgX3fhC7QJ2pZx_LM2RgH6vOHz3X-ICoNtqQZq1vaFt_JrThWUhRxhOfqYTw5sQVoSrtC9ynuKynS-ekLlbQ3AwgDvSCCQ1PpO-wSpo6bMlchNPImzdEp12qsaFzS2hIsLe25tsH9JSvPE-M8gu8KaRdN4o59ktEhMDKqSDjf04AVPb1QkI6b7lFuCppmOVhJWS-QdLK62oTDoqU2LTLAawl3e5srqdpQMscp-DM8fmtJp_LEYo687RZwBkdqTLjiGLTj1iEtGi_Mxm4cbNZizLuJMF7DrD8cOcaOIBUO6owBkdZ0fu_RkJIF_N0rcM52xz7gLmJqsuiH__wRXbGcfTR6X2hrt2Ap6bxy5QKl1eSltLDI_JMNfpZpKDVRuKClDaRGcVGUzAWw3NaP9PFCXmn3SUOSZOJw5tEXQo247sNErYBNKwP6TjMhQS4C-Sve8");
//
//        // Make the GET request and retrieve the response entity
//        return restTemplate.getForEntity(url, String.class, params);
//    }
}
