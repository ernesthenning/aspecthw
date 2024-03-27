package com.example.autheticationhw.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity{

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Order> orders;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                '}';
    }
}
