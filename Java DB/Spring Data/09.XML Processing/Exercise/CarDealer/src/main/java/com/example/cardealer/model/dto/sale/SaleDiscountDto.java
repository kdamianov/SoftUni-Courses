package com.example.cardealer.model.dto.sale;

import com.example.cardealer.model.dto.cars.CarBasicInfoDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDiscountDto {
    @XmlElement
    private CarBasicInfoDto car;

    @XmlElement(name = "customer-name")
    private String name;

    @XmlElement
    private Double discount;

    @XmlElement

    private BigDecimal price;

    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;
}
