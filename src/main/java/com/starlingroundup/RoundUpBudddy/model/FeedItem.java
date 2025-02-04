package com.starlingroundup.RoundUpBudddy.model;

import lombok.Builder;

import java.time.Instant;

@Builder
public record FeedItem(
        String feedItemUid,
        String categoryUid,
        Amount amount,
        Amount sourceAmount,
        String direction,
        Instant updatedAt,
        Instant transactionTime,
        Instant settlementTime,
        String source,
        String status,
        String transactingApplicationUserUid,
        String counterPartyType,
        String counterPartyUid,
        String counterPartyName,
        String counterPartySubEntityUid,
        String counterPartySubEntityName,
        String counterPartySubEntityIdentifier,
        String counterPartySubEntitySubIdentifier,
        String reference,
        String country,
        String spendingCategory,
        boolean hasAttachment,
        boolean hasReceipt,
        BatchPaymentDetails batchPaymentDetails
) {}
