package com.example.cardealer.model.dto.sale;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleDiscountsRootDto {
    @XmlElement(name = "sale")
    private List<SaleDiscountDto> sales;
}
