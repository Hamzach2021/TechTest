package com.starlingroundup.RoundUpBudddy.controller;

import com.starlingroundup.RoundUpBudddy.model.Transactions;
import com.starlingroundup.RoundUpBudddy.service.RoundupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactions")
@Slf4j
public class RoundUpController {
    private final RoundupService roundUpService;
    private static final Logger logger = Logger.getLogger(RoundUpController.class.getName());


    public RoundUpController(RoundupService roundupService) {
        this.roundUpService = roundupService;
    }

    @GetMapping("/{accountUid}/{categoryUid}")
    public void roundUp(
            @PathVariable String accountUid,
            @PathVariable String categoryUid) {
        logger.log(Level.INFO, "Received Round up request");
        roundUpService.roundUp(accountUid, categoryUid);
    }
//    @GetMapping("/getransactions")
//    public ResponseEntity<List<Transaction>> callTransactionApi() {
//        return ResponseEntity.ok(transactionService.getTransactions().getBody());
//    }
}
