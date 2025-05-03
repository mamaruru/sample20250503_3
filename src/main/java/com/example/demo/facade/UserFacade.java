package com.example.demo.facade;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserFacade {

    private final UserRepository repository;

    public UserFacade(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> findAllUsers() {
        return repository.findAll();
    }

    public Optional<UserEntity> findUserById(Long id) {
        return repository.findById(id);
    }

    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }
}