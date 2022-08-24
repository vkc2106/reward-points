package com.example.rewards.service;

import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.model.Transaction;
import com.example.rewards.pojo.Tran;
import com.example.rewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RewardService {


    @Autowired
    TransactionRepository transactionRepository;


    // logic to caluclate the rewards for the given price.
    public int calculateRewards(int price) {
        if (price >=50 && price < 100) {
            return price-50;
        } else if (price >100){
            return (2*(price-100) + 50);
        }
        return 0;
    }


 // caluclating the reward points for customer.
  public  int  getRewards(String customerId) {

      List<Transaction> transactionList =  transactionRepository.findAll();
        if(transactionList.size()<=0)
            throw new CustomerNotFoundException("customer not found::"+customerId);
        return transactionList.stream().filter(tr-> customerId.equalsIgnoreCase(tr.getCustomerId())).map(Transaction::getReward).reduce(0,(a,b)->a+b);
    }


    // returns all reward points by date to the customer
    public List<Tran> getRewardPointsByDate(String customerId){
        List<Transaction> transactionList =  transactionRepository.findAll();
        List<Tran> trans=new ArrayList<>();
        if(transactionList.size()<=0)
            throw new CustomerNotFoundException("customer not found::"+customerId);
         transactionList.stream().filter(tr-> customerId.equalsIgnoreCase(tr.getCustomerId())).forEach(transaction -> {
            Tran tran=new Tran(transaction.getCustomerId(),transaction.getReward(),transaction.getDate());
            trans.add(tran);
        });

         return trans;
    }

    // caluclate montly rewards ;;;; 6-june, 7-july.
    public int caluclateMontlyrewards(String customerId, int month) {

        int montlyReward = 0;

        List<Transaction> transactionList = transactionRepository.findAll();
        for (Transaction tr : transactionList) {
            if (customerId.equalsIgnoreCase(tr.getCustomerId())) {
                if (tr.getDate().getMonth() == month)
                    montlyReward = montlyReward + tr.getReward();
            }
        }
        return montlyReward;
    }



}
