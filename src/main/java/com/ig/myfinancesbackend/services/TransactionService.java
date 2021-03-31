package com.ig.myfinancesbackend.services;

import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import com.ig.myfinancesbackend.exceptions.RuleBusinessException;
import com.ig.myfinancesbackend.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    public final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction find(Integer id) {
        Optional<Transaction> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Transaction> findAll() {

        return repository.findAll();
    }

    @Transactional
    public Transaction save(Transaction transaction) {
        validate(transaction);
        return repository.save(transaction);
    }

    public void validate(Transaction transaction) {

        if (transaction.getDescription() == null || transaction.getDescription().trim().equals("")) {
            throw new RuleBusinessException("Please provide a valid description.");
        }

        if (transaction.getMounth() == null || transaction.getMounth() < 1 || transaction.getMounth() > 12) {
            throw new RuleBusinessException("Please provide a valid mounth");
        }

        if (transaction.getYear() == null || transaction.getYear().toString().length() != 4) {
            throw new RuleBusinessException("Please provide a valid year");
        }

        if (transaction.getUser() == null || transaction.getUser().getId() == null) {
            throw new RuleBusinessException("Please provide a valid user");
        }

        if (transaction.getValue() == null || transaction.getValue().compareTo(BigDecimal.ZERO) < 1) {
            throw new RuleBusinessException("Please provide a valid value");
        }

        if (transaction.getType() == null) {
            throw new RuleBusinessException("Please provide a transaction type.");
        }
    }

    @Transactional(readOnly = true)
    public BigDecimal getBalancePerUser(Integer id) {

        BigDecimal income = repository.getBalancePerUser(id, TypeTransaction.INCOME);
        BigDecimal outcome = repository.getBalancePerUser(id, TypeTransaction.OUTCOME);

        if (income == null) {
            income = BigDecimal.ZERO;
        }

        if (outcome == null) {
            outcome = BigDecimal.ZERO;
        }
        return income.subtract(outcome);
    }
}
