package com.example.xmlprocessingexercise.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    private User seller;

    @ManyToOne(fetch = FetchType.EAGER)

    private User buyer;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

}
