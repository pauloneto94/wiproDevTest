package com.pauloNeto.wipro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Product {

    @Id
    @EqualsAndHashCode.Exclude
    private String code;

    @NotEmpty
    private String description;

    @NotNull
    private ProductActivation productActivation;

    @NotNull
    private int price;

    @NotNull
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NonNull
    @JsonIgnore
    private User user;

    public Product(){}

    public Product(String code, String description, ProductActivation productActivation, int price, Date date, User user){
        this.code = code;
        this.description = description;
        this.productActivation = productActivation;
        this.price = price;
        this.date = date;
        this.user = user;
    }

    public ProductActivation getProductActivation() {
        return productActivation;
    }

    public void setProductActivation(ProductActivation productActivation) {
        this.productActivation = productActivation;
    }
}
