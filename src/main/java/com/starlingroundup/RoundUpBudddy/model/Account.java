package com.starlingroundup.RoundUpBudddy.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Account {

    private String accountUid;
    private String accountType;
    private String defaultCategory;
    private String currency;
    private Date createdAt;
    private String name;

}