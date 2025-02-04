package com.starlingroundup.RoundUpBudddy.model;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record Transactions(List<FeedItem> feedItems) {}