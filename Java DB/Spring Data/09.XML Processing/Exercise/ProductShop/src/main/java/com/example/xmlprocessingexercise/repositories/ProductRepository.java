package com.example.xmlprocessingexercise.repositories;

import com.example.xmlprocessingexercise.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNull(BigDecimal lowerPrice, BigDecimal upperPrice);
}
