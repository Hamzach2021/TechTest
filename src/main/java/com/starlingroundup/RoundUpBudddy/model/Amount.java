package com.starlingroundup.RoundUpBudddy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Amount( String currency, long minorUnits) {
    public Amount {
        if (minorUnits < 0L) {
            throw new IllegalArgumentException("Amount cannot be less than 0");
        }

        //Could do a currency validation

    }
}