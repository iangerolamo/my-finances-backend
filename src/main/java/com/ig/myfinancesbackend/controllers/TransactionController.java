package com.ig.myfinancesbackend.controllers;

import com.ig.myfinancesbackend.models.Balance;
import com.ig.myfinancesbackend.models.Transaction;
import com.ig.myfinancesbackend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Transaction obj = transactionService.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
