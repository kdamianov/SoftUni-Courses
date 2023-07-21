package com.example.cardealer.model.dto.parts;

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

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartNameAndPriceRootDto {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private BigDecimal price;
}
