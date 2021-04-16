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

    // obter todos os usuários

    public List<User> findAll() {

        return repository.findAll();
    }

    // autenticar usuário

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

    // salvar usuário

    public User saveUser(User user) {
        validateEmail(user.getEmail());
        return repository.save(user);
    }

    // verificar e-mail do usuário

    public void validateEmail(String email) {
        boolean exist = repository.existsByEmail(email);
        if (exist) {
            throw new RuleBusinessException("There is already a registered user with that user");
        }
    }

    // verificar usuário por id

    public void find(Integer id) {

        Optional<User> obj = repository.findById(id);
    }

    // deletar usuário

    public void delete(Integer id) {
        find(id);
        repository.deleteById(id);
    }

    // obter usuário por id

    public Optional<User> getById(Integer id) {

        return repository.findById(id);
    }
}
