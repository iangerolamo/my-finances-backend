package com.ig.myfinancesbackend.services;

import com.ig.myfinancesbackend.entities.User;
import com.ig.myfinancesbackend.exceptions.AuthenticationError;
import com.ig.myfinancesbackend.exceptions.RuleBusinessException;
import com.ig.myfinancesbackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {

        return repository.findAll();
    }

    public User authenticate(String email, String password) {
        Optional<User> user = repository.findByEmail(email);

        if (user.isEmpty()) {
            throw new AuthenticationError("User not found");
        }

        if (!user.get().getPassword().equals(password)) {
            throw new AuthenticationError("Invalid password");
        }

        return user.get();
    }

    public User saveUser(User user) {
        validateEmail(user.getEmail());
        return repository.save(user);
    }

    public void validateEmail(String email) {
        boolean exist = repository.existsByEmail(email);
        if (exist) {
            throw new RuleBusinessException("There is already a registered user with that user");
        }
    }

    public void find(Integer id) {
        Optional<User> obj = repository.findById(id);
    }

    public void delete(Integer id) {
        find(id);
        repository.deleteById(id);
    }

    public Optional<User> getById(Integer id) {
        return repository.findById(id);
    }


}
