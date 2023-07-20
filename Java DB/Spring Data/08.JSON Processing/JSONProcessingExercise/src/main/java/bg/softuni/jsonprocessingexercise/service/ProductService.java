package bg.softuni.jsonprocessingexercise.service;

import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lowerRange, BigDecimal upperRange);
}
