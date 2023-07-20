package com.example.xmlprocessingexercise.model.dto.users;

import com.example.xmlprocessingexercise.model.dto.products.ProductsSoldWithCountDto;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersWithProductsDto {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "age")
    private Integer age;

    @XmlElement(name = "sold-products")
    private ProductsSoldWithCountDto soldProducts;

    public UsersWithProductsDto(ProductsSoldWithCountDto soldProducts) {
        this.soldProducts = new ProductsSoldWithCountDto();
    }
}
