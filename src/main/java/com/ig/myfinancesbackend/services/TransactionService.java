package com.ig.myfinancesbackend.services;

import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository repository;

    public Transaction find(Integer id) {
        Optional<Transaction> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Transaction> findAll() {

        return repository.findAll();
    }
}
