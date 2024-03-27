package com.example.autheticationhw.service;

import com.example.autheticationhw.model.Order;
import com.example.autheticationhw.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository repository;

    public Order get(long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void delete(long id) {
       if(get(id) != null) {
           repository.delete(get(id));
       } else {
           throw new RuntimeException();
       }

    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order update(Order order) {
        if(order != null && get(order.getId()) != null) {
            return repository.save(order);
        } else {
            throw new RuntimeException();
        }
    }
}
