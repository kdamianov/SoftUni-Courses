package com.example.springdataintroexercise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")

public class Book extends BaseEntity{
    @Column(length = 50, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private EditionType editionType;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer copies;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Enumerated(EnumType.ORDINAL)
    private AgeRestriction ageRestriction;
    @ManyToOne
    private Author author;
    @ManyToMany
    private Set<Category> categories;

    public Book(EditionType editionType, LocalDate releaseDate, Integer copies,
                BigDecimal price, AgeRestriction ageRestriction, String title, Author author, Set<Category> categories) {
        super();
        this.editionType = editionType;
        this.releaseDate = releaseDate;
        this.copies = copies;
        this.price = price;
        this.ageRestriction = ageRestriction;
        this.title = title;
        this.author = author;
        this.categories = categories;
    }


}
