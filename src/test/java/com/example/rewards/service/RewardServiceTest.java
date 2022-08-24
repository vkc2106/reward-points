package com.example.rewards.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardServiceTest {


    @Test
    public  void   calculateRewardsTest() {

        RewardService rewardService=new RewardService();
       int p= rewardService.calculateRewards(55);
        assertEquals(5,p);

        int p2= rewardService.calculateRewards(105);
        assertEquals(60,p2);


        int p3= rewardService.calculateRewards(155);
        assertEquals(160,p3);

        int p4= rewardService.calculateRewards(45);
        assertEquals(0,p4);
    }

    }
