package com.example.xmlprocessingexercise.model.dto.users;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithProductsDto {

    @XmlAttribute(name = "first_name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "product")
    @XmlElementWrapper(name = "sold_products")
    private List<ProductWithBuyerDto> products;

}
