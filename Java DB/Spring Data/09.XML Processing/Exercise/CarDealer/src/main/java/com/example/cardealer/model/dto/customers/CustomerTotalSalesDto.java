package com.example.cardealer.model.dto.customers;

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

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSalesDto {
    @XmlAttribute(name = "full-name")
    private String name;

    @XmlAttribute(name = "bought-cars")
    private int boughtCars;

    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;
}
