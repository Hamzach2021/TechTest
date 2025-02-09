package com.starlingroundup.RoundUpBudddy.service;

import com.starlingroundup.RoundUpBudddy.model.Amount;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoundupService {
    private final TransactionService transactionService;
    private final GoalService goalService;
    private static final Logger logger = LoggerFactory.getLogger(RoundupService.class);


    public RoundupService(TransactionService transactionService, GoalService goalService) {
        this.goalService = goalService;
        this.transactionService = transactionService;
    }

    public String roundUp(String accountUid, String categoryUid){
        Amount amount = getSpendingRoundUp(accountUid, categoryUid);
        try {
            goalService.saveMoney(amount, accountUid);
        }catch(Exception e){
            logger.error(e.getMessage());
        }

        return "Successfully Saved: " + amount + " to account " + accountUid;

    }
    // I would've used Rest client as Rest template is quite outdated(not deprecated. its feature complete)
    //Due to limited time I have rushed the overall attempt in my opinion. I also ran into a lot of API key issues
    public Amount getSpendingRoundUp(String accountUid, String categoryUid){

        logger.info("Calculating RoundUp: ");
       long roundUp = transactionService.getTransactions(accountUid, categoryUid).feedItems()
                .stream().filter(transaction -> transaction.direction().equals("OUT"))
                .mapToLong(value -> calculateRoundUp(value.amount().minorUnits()))
                .sum();

       logger.info( "The round is :" + String.valueOf(roundUp));
       return new Amount("GBP", roundUp);

    }

    private long calculateRoundUp(long minorUnits) {
        long remainder = minorUnits % 100;
        return remainder == 0 ? 0 : (100 - remainder);
    }

}
