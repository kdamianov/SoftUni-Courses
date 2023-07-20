package com.example.xmlprocessingexercise.service;

import com.example.xmlprocessingexercise.model.dto.products.ProductSeedDto;
import com.example.xmlprocessingexercise.model.dto.products.ProductViewRootDto;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithNoBuyer();
}
