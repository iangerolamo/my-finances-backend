package com.ig.myfinancesbackend.controllers;

import com.ig.myfinancesbackend.dto.UserDTO;
import com.ig.myfinancesbackend.entities.User;
import com.ig.myfinancesbackend.exceptions.AuthenticationError;
import com.ig.myfinancesbackend.exceptions.RuleBusinessException;
import com.ig.myfinancesbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody UserDTO userDTO) {
        try {
            User authenticatedUser = userService.authenticate(userDTO.getEmail(), userDTO.getPassword());
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } catch (AuthenticationError e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

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

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
