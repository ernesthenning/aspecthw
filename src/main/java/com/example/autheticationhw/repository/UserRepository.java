package com.example.autheticationhw.repository;

import com.example.autheticationhw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
