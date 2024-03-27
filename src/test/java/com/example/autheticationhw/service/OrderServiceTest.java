package com.example.autheticationhw.service;

import com.example.autheticationhw.model.Order;
import com.example.autheticationhw.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService service;
    @Autowired
    private UserService userService;

    @Test
    void runAllMethods() {
        Order order = service.get(1);
        order.setDescription("new description");
        service.update(order);
        service.delete(1);
        assertThrows(RuntimeException.class, () -> service.get(1));
        service.create(new Order("new description", Status.ACCEPTED, userService.get(1)));
    }

}
