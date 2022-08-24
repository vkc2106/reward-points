package com.example.rewards.controller;


import com.example.rewards.pojo.Tran;
import com.example.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RewardPointController {

    @Autowired
    RewardService rewardService;

    // rest endpoint send the customerid and get total rewards.
    @GetMapping("/rewardPoints")
    int getRewardPoints(@RequestParam String customerId)
    {
       return  rewardService.getRewards(customerId);
    }

    // this endpoint returns customers all the rewards.
    @GetMapping("/rewardPointsByDate")
    List<Tran> getRewardPointsBydate(@RequestParam String customerId)
    {
        return  rewardService.getRewardPointsByDate(customerId);
    }



}
