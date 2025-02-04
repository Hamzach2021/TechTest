package com.starlingroundup.RoundUpBudddy.utils;

import org.springframework.beans.factory.annotation.Value;

public final class Urls {

    @Value("${accountUid}")
    private String accountUid;

    @Value("${categoryUid}")
    private String categoryUid;

    public static final String API_STARLING_BANK_TRANSACTIONS = "https://api-sandbox.starlingbank.com/api/v2/feed/account/{accountUid}/category/{categoryUid}?changesSince={changesSince}";
    public static final String API_STARLING_BANK_SAVINGS_GOALS_URL = "https://api-sandbox.starlingbank.com/api/v1/savings-goals/{savingsGoalUid}";
    public static final String API_STARLING_BANK_PUT_SAVINGS_URL = "https://api-sandbox.starlingbank.com/api/v2/account/{accountUid}/savings-goals/{savingsGoalUid}/add-money/{transferUid}";
    public static final String API_STARLING_BANK_ACCOUNT_INFO = "https://api-sandbox.starlingbank.com/api/v2/accounts";
    public static final String API_STARLING_BANK_SAVINGS_GOALS_LIST_URL = "https://api-sandbox.starlingbank.com/api/v2/account/{accountUid}/savings-goals";
}
