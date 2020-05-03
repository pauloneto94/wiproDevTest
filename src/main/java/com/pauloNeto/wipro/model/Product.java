package com.pauloNeto.wipro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Getter @Setter @NoArgsConstructor
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

}
