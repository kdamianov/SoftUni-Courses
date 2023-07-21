package com.example.xmlprocessingexercise.service.impl;

import com.example.xmlprocessingexercise.model.dto.products.ProductSeedDto;
import com.example.xmlprocessingexercise.model.dto.products.ProductViewRootDto;
import com.example.xmlprocessingexercise.model.dto.products.ProductWithSellerDto;
import com.example.xmlprocessingexercise.model.entities.Product;
import com.example.xmlprocessingexercise.repositories.ProductRepository;
import com.example.xmlprocessingexercise.service.CategoryService;
import com.example.xmlprocessingexercise.service.ProductService;
import com.example.xmlprocessingexercise.service.UserService;
import com.example.xmlprocessingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public long getCount() {
        return productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        if (productRepository.count() == 0) {
            products
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = modelMapper.map(productSeedDto, Product.class);

                        product.setSeller(userService.getRandomUser());
                        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
                            product.setBuyer(userService.getRandomUser());
                        }

                        product.setCategories(categoryService.getRandomCategories());

                        return product;
                    })
                    .forEach(productRepository::save);
        }
    }

    @Override
    public ProductViewRootDto findProductsInRangeWithNoBuyer() {
        ProductViewRootDto rootDto = new ProductViewRootDto();

        rootDto.setProducts(productRepository
                .findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                .stream()
                .map(product -> {
                    ProductWithSellerDto productWithSellerDto = modelMapper.map(product, ProductWithSellerDto.class);
                    productWithSellerDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName() == null ? "" :product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));
                    return productWithSellerDto;
                })
                .toList());

        return rootDto;
    }

}
