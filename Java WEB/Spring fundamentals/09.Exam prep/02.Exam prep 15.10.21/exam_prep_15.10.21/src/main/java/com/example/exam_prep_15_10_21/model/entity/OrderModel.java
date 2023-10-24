package com.example.exam_prep_15_10_21.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderModel extends BaseEntity {
    //•	Has a Name
    //  o	The length of the name must be between 3 and 20 characters (both numbers are INCLUSIVE).
    //•	Has a Price
    //  o	The price must be a positive number
    //•	Has an Order time
    //  o	The date and time that CANNOT BE IN THE FUTURE!!!
    //•	Has a Category
    //  o	Has ONLY ONE category
    //  o	This is the relation with categories.
    //•	Has a Description
    //  o	The length of the description must be at least 5 (INCLUSIVE) characters
    //  o	The description is a long text field.
    //•	Has an Employee (user)
    //  o	A user that adds this order to the Coffee Shop application

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Positive
    private BigDecimal price;
    @Column(name = "order_time", nullable = false)
    private LocalDateTime orderTime;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    @ManyToOne
    private UserModel employee;
    @ManyToOne
    private CategoryModel category;

    public OrderModel() {
    }

    public String getName() {
        return name;
    }

    public OrderModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public UserModel getEmployee() {
        return employee;
    }

    public OrderModel setEmployee(UserModel employee) {
        this.employee = employee;
        return this;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public OrderModel setCategory(CategoryModel category) {
        this.category = category;
        return this;
    }
}
