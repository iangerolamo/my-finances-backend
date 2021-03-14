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

        Transaction transactionOne = new Transaction(null, "Salário", 5000.00, "entrada");
        Transaction transactionTwo = new Transaction(null, "Parcela do carro", 380.00, "saída");
        Transaction transactionThree = new Transaction(null, "Curso de programação", 150.00, "saída");
        Transaction transactionFour = new Transaction(null, "Conta de luz", 39.00, "saída");
        Balance balance = new Balance(0.0, 0.0, 0.0);

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(transactionOne);
        transactions.add(transactionTwo);
        transactions.add(transactionThree);
        transactions.add(transactionFour);

        double total = 0.0;
        double income = 0.0;
        double outcome = 0.0;
//        String type = "";

//        for (int i = 0; i < transactions.toArray().length; i++) {
//            if (transactions.get(i).getType().equals("entrada")) {
//                income = income + transactions.get(i).getValue();
//            }
//            if (transactions.get(i).getType().equals("saída")) {
//                outcome = outcome + transactions.get(i).getValue();
//            }
//            total = (income - outcome);
//        }

        for (int i = 0; i < transactions.toArray().length; i++) {
            String type = transactions.get(i).getType();
            switch (type) {
                case "entrada":
                    income = income + transactions.get(i).getValue();
                    break;
                case "saída":
                    outcome = outcome + transactions.get(i).getValue();
                    break;
            }
            total = (income - outcome);
        }
        System.out.println(total);

        return transactions;



    }
}
