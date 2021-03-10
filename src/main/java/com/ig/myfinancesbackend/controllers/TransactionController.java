package com.ig.myfinancesbackend.controllers;

import com.ig.myfinancesbackend.models.Balance;
import com.ig.myfinancesbackend.models.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/transactions")
public class TransactionController {

    @RequestMapping(method= RequestMethod.GET)
    public List<Transaction> listTransactions() {

        Transaction transactionOne = new Transaction(UUID.randomUUID(), "Salário", 5000.00, "entrada");
        Transaction transactionTwo = new Transaction(UUID.randomUUID(), "Parcela do carro", -380.00, "saída");
        Transaction transactionThree = new Transaction(UUID.randomUUID(), "Curso de programação", -150.00, "saída");
        Balance balance = new Balance(0.0, 0.0, 0.0);

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(transactionOne);
        transactions.add(transactionTwo);
        transactions.add(transactionThree);

        double total = 0.0;

        for (int i = 0; i < transactions.toArray().length; i++) {
            total = (total + transactions.get(i).getValue());
        }

        System.out.println(total);

        return transactions;



    }
}
