package com.example.autheticationhw.service;

import com.example.autheticationhw.model.Order;
import com.example.autheticationhw.model.Status;
import com.example.autheticationhw.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void runAllMethods() {
        User user = service.get(1);
        user.setName("new name");
        service.update(user);
        service.delete(1);
        assertThrows(RuntimeException.class, () -> service.get(1));
        service.get(1);
        service.create(new User("test email", "test name", null));
    }
}
