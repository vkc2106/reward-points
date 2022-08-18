package com.example.rewards.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {

    String customerId;
    int price;
    int reward;

}
