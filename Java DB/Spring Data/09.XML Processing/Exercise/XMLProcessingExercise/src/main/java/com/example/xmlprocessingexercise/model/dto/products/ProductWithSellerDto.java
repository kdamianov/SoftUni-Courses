package com.example.xmlprocessingexercise.model.dto.products;

import com.example.xmlprocessingexercise.model.entities.User;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)

public class ProductWithSellerDto {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private BigDecimal price;
    @XmlAttribute
    private String seller;
}
