package com.starlingroundup.RoundUpBudddy;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class RoundUpBudddyApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoundUpBudddyApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RestClient transactionClient() {
		String apiKey = System.getenv("Authorization"); // Read from ENV
//        if (apiKey == null || apiKey.isEmpty()) {
//            throw new IllegalStateException("Authorization token is missing");
//        }

		return RestClient.builder()
				.baseUrl("https://api-sandbox.starlingbank.com")
				.defaultHeader("Authorization", "Bearer " + apiKey)
				.defaultHeader("accept", "application/json")
				.defaultHeader("User-Agent", "Java HttpClient")
				.defaultHeader("Accept-Encoding", "gzip, deflate, br")
				.defaultHeader("Connection", "keep-alive")
				.defaultHeader("Host", "api-sandbox.starlingbank.com")
				.defaultHeader("Content-Type", "application/json")
				.build();
	}


//	@Bean
//	RestClient restClient(RestClient.Builder builder) {
//		return builder
//				.baseUrl("https://api-sandbox.starlingbank.com/")
//				.defaultHeader("Accept", "application/json")
//				.defaultHeader("Authorization", "Bearer " + System.getenv("Authorization"))
//				.build();
//
//	}
////
//	@Bean
//	ApplicationRunner applicationRunner(RestClient restClient){
//		return args -> {
//
//			AccountResponse transactions = restClient.get()
//					.uri("/api/v2/feed/accounts")
//					.retrieve()
//					.body(AccountResponse.class);
//
//			System.out.println(transactions);
//
//
//		};
//	}


	public record AccountResponse(List<Account> accounts) {

		public record Account(
				String accountUid,
				String accountType,
				String defaultCategory,
				String currency,
				Instant createdAt,
				String name
		) {}
	}
//	public record Transactions(List<FeedItem> feedItems) {}
//
//	public record FeedItem(
//			String feedItemUid,
//			String categoryUid,
//			Amount amount,
//			Amount sourceAmount,
//			String direction,
//			Instant updatedAt,
//			Instant transactionTime,
//			Instant settlementTime,
//			String source,
//			String status,
//			String transactingApplicationUserUid,
//			String counterPartyType,
//			String counterPartyUid,
//			String counterPartyName,
//			String counterPartySubEntityUid,
//			String counterPartySubEntityName,
//			String counterPartySubEntityIdentifier,
//			String counterPartySubEntitySubIdentifier,
//			String reference,
//			String country,
//			String spendingCategory,
//			boolean hasAttachment,
//			boolean hasReceipt,
//			BatchPaymentDetails batchPaymentDetails
//	) {}
//
//	public record Amount(
//			String currency,
//			long minorUnits
//	) {}
//
//	public record BatchPaymentDetails() {}


}
