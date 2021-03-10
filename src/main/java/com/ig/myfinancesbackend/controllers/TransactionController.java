package com.ig.myfinancesbackend.controllers;

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
    public List<Transaction> listar() {

        Transaction transaction1 = new Transaction(UUID.randomUUID(), "Salário", 5000.00, "entrada");
        Transaction transaction2 = new Transaction(UUID.randomUUID(), "Parcela do carro", 380.00, "saída");

        List<Transaction> lista = new ArrayList<>();
        lista.add(transaction1);
        lista.add(transaction2);

        return lista;

    }
}
