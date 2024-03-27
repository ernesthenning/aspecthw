package com.example.autheticationhw.repository;

import com.example.autheticationhw.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
