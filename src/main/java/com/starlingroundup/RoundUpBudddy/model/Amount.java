package com.starlingroundup.RoundUpBudddy.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Builder
public record Amount( String currency, long minorUnits) {
    public Amount {
        if (minorUnits < 0L) {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }

        //Could do a currency validation

    }
}