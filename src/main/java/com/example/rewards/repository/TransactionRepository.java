package com.example.rewards.repository;

import com.example.rewards.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Repository
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
