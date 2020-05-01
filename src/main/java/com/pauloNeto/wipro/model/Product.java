package com.pauloNeto.wipro.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
public class Product {

    @Id
    private String code;

    private String description;
    private int price;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;


    public Product(String code, String description, int price, Date date, User user){
        this.code = code;
        this.description = description;
        this.price = price;
        this.date = date;
        this.user = user;
    }
}
