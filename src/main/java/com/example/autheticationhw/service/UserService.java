package com.example.autheticationhw.service;

import com.example.autheticationhw.model.User;
import com.example.autheticationhw.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User get(long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void delete(long id) {
        if(get(id) != null) {
            repository.delete(get(id));
        } else {
            throw new RuntimeException();
        }
    }

    public User update(User user) {
        if(user != null && get(user.getId()) != null) {
            return repository.save(user);
        } else {
            throw new RuntimeException();
        }
    }

    public User create(User user) {
        return repository.save(user);
    }
}
