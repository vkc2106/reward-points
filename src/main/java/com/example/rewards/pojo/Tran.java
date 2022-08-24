package com.example.rewards.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Tran {

    String customerId;
    int rewardPrice;
    Date date;

}
