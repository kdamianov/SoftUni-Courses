package com.example.xmlprocessingexercise.model.dto.products;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto {

    @Size(min = 3)
    private String name;
    private BigDecimal price;
}
