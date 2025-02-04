package com.starlingroundup.RoundUpBudddy.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SavingGoal {
    private String description;
    private String savingsGoalUid;
    private String name;
    private Amount target;
    private Amount totalSaved;
    private Integer savedPercentage;
    private SavingGoalState state;

}
