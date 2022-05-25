package com.example.paymybuddy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, length = 50)
    private String email;

    @Column
    private String password;

    @Column
    private Double balance;

    @ManyToMany
    @JoinTable(
            name = "connections",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "connection_Id"))

    private List<User> connections = new ArrayList<>();

    public List<User> getConnections() {
        return connections;
    }

    public void setConnections(List<User> connections) {
        connections = connections;
    }
}
