package org.flessi.api.service;

import lombok.AllArgsConstructor;
import org.flessi.api.model.User;
import org.flessi.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
