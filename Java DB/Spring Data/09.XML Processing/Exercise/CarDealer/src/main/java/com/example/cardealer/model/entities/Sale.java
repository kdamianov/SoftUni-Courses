package com.example.cardealer.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    private BigDecimal discount;

    public Sale() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
