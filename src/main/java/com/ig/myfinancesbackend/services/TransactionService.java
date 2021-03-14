package com.ig.myfinancesbackend.services;

import com.ig.myfinancesbackend.models.Transaction;
import com.ig.myfinancesbackend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction find(Integer id) {
        Optional<Transaction> obj = transactionRepository.findById(id);
        return obj.orElse(null);
    }
}
