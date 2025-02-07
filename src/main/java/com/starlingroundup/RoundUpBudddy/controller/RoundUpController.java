package com.starlingroundup.RoundUpBudddy.controller;

import com.starlingroundup.RoundUpBudddy.service.GoalService;
import com.starlingroundup.RoundUpBudddy.service.RoundupService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transactions")
@Slf4j
public class RoundUpController {
    private final RoundupService roundUpService;
    private static final Logger logger = LoggerFactory.getLogger(RoundUpController.class);


    public RoundUpController(RoundupService roundupService) {
        this.roundUpService = roundupService;
    }

    @GetMapping("/{accountUid}/{categoryUid}")
    public void roundUp(
            @PathVariable String accountUid,
            @PathVariable String categoryUid) {
        logger.info( "Received Round up request");
        roundUpService.roundUp(accountUid, categoryUid);
    }
}