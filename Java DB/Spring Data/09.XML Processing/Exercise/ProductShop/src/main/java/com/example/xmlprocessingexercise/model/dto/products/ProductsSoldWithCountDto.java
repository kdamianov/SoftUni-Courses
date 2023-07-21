package com.example.xmlprocessingexercise.model.dto.products;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldWithCountDto {

    @XmlAttribute
    private Integer count;
    @XmlElement(name = "product")
    private List<ProductsBasicInfoDto> products;
}
