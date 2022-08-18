package com.example.rewards.controller;


import com.example.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
public class RewardPointController {

    @Autowired
    RewardService rewardService;


    @GetMapping("/rewardPoints")
    int getRewardPoints(@RequestParam String customerId)
    {
       return  rewardService.getRewards(customerId);
    }

}
