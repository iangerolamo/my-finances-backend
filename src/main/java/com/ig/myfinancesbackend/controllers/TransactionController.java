package com.ig.myfinancesbackend.controllers;

import com.ig.myfinancesbackend.dto.TransactionDTO;
import com.ig.myfinancesbackend.entities.Transaction;
import com.ig.myfinancesbackend.entities.User;
import com.ig.myfinancesbackend.entities.enums.TypeTransaction;
import com.ig.myfinancesbackend.exceptions.RuleBusinessException;
import com.ig.myfinancesbackend.services.TransactionService;
import com.ig.myfinancesbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    // obter transação por id

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> find(@PathVariable Integer id) {
        List<Transaction> list = transactionService.getTransactionByUser(id);
        return ResponseEntity.ok().body(list);
    }

    // obter todas as transações

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> findAll() {
        List<Transaction> list = transactionService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // salvar transação

    @PostMapping
    private ResponseEntity save(@RequestBody TransactionDTO transactionDTO) {
        try {
            Transaction entity = toConvert(transactionDTO);
            entity = transactionService.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        } catch (RuleBusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // deletar transação

    @DeleteMapping("{id}")
    private ResponseEntity delete(@PathVariable("id") Integer id) {
        return transactionService.getById(id).map(entity -> {
            transactionService.delete(entity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }).orElseGet(() ->
                new ResponseEntity("Transaction not found.", HttpStatus.BAD_REQUEST));
    }

    private Transaction toConvert(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDTO.getId());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setMounth(transactionDTO.getMounth());
        transaction.setYear(transactionDTO.getYear());
        transaction.setValue(transactionDTO.getValue());

        User user = userService
                .getById(transactionDTO.getUser())
                .orElseThrow(() -> new RuleBusinessException("User not found for informed id"));

        transaction.setUser(user);
        transaction.setType(TypeTransaction.valueOf(transactionDTO.getType()));
        return transaction;
    }
}
