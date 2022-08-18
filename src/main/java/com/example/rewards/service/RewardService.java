package com.example.rewards.service;

import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.model.Transaction;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;



@Service
public class RewardService {

    ArrayList<Transaction> list=new ArrayList<>();

    int calculateRewards(int price) {
        if (price >=50 && price < 100) {
            return price-50;
        } else if (price >100){
            return (2*(price-100) + 50);
        }
        return 0;
    }

    public boolean checkCustomerExists(String customerId)
    {
        return list.stream()
                .filter(x -> x.getCustomerId().equalsIgnoreCase(customerId))
                .count() > 0;
    }

 // caluclating the reward points for customer.
  public  int  getRewards(String customerId) {
        if(!checkCustomerExists(customerId))
            throw new CustomerNotFoundException("customer not found::"+customerId);
        return list.stream().filter(tran-> tran.getCustomerId().equalsIgnoreCase(customerId)).map(Transaction::getReward).reduce(0,(a,b)->a+b);
    }

    // adding the transactions
    void addTransaction(String customerId,int price) {
        Transaction transaction = new Transaction(customerId,price,calculateRewards(price));
        this.list.add(transaction);
    }




   // creating the transactions on the application start up.
    @EventListener(ApplicationReadyEvent.class)
    void create3MonthsTransactions()
    {
        addTransaction("chaitu25", 175);
        addTransaction("abcd", 65);
        addTransaction("chaitu25", 175);
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
