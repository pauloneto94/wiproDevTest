package com.pauloNeto.wipro.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Product> productList;

    public User(){}

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

}
