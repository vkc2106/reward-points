package com.example.rewards.util;

import com.example.rewards.model.Transaction;
import com.example.rewards.repository.TransactionRepository;
import com.example.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class TransactionUtil {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RewardService rewardService;

    // adding the transactions to the H2 Data Base
    void addTransaction(String customerId,int price) {
        Transaction transaction = new Transaction( new Random().nextLong(),customerId,price,rewardService.calculateRewards(price),new Date());
        transactionRepository.save(transaction);
    }


    // creating the transactions on the application start up.
    @EventListener(ApplicationReadyEvent.class)
    void create3MonthsTransactions()
    {
        addTransaction("chaitu25", 175);
        addTransaction("abcd", 65);
        addTransaction("chaitu25", 105);
        addTransaction("abcd", 81);
        addTransaction("mani123", 73);
        addTransaction("robbion", 155);
        addTransaction("mathew", 175);
        addTransaction("chaitu25", 137);
        addTransaction("chaitu25", 85);
        addTransaction("mani123", 73);
        addTransaction("robbion", 155);
        addTransaction("mathew", 175);
        addTransaction("chaitu25", 130);
        addTransaction("chaitu25", 195);
        addTransaction("mani123", 73);
        addTransaction("robbion", 158);
        addTransaction("mathew", 105);
        addTransaction("chaitu25", 119);
        addTransaction("chaitu25", 95);


    }
}
