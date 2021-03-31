package com.ig.myfinancesbackend.controllers;

import com.ig.myfinancesbackend.dto.UserDTO;
import com.ig.myfinancesbackend.entities.User;
import com.ig.myfinancesbackend.exceptions.AuthenticationError;
import com.ig.myfinancesbackend.exceptions.RuleBusinessException;
import com.ig.myfinancesbackend.services.TransactionService;
import com.ig.myfinancesbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;
    private final TransactionService transactionService;

    public UserController(UserService userService, TransactionService transactionService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    // obter todos os usuários

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // autenticar usuário

    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody UserDTO userDTO) {
        try {
            User authenticatedUser = userService.authenticate(userDTO.getEmail(), userDTO.getPassword());
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } catch (AuthenticationError e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // salvar usuário

    @PostMapping
    public ResponseEntity save(@RequestBody UserDTO userDTO) {

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();

        try {
            User userSave = userService.saveUser(user);
            return new ResponseEntity<>(userSave, HttpStatus.CREATED);
        } catch (RuleBusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // deletar usuário

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // obter saldo do usuário

    @GetMapping("{id}/balance")
    public ResponseEntity getBalance(@PathVariable("id") Integer id) {
        Optional<User> user = userService.getById(id);

        if (user.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        BigDecimal balance = transactionService.getBalancePerUser(id);
        return ResponseEntity.ok(balance);
    }
}
