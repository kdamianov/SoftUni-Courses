package com.example.cardealer.model.dto.parts;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class PartSeedDto {
    @XmlAttribute
    @Size(min = 3)
    private String name;

    @XmlAttribute
    @Positive
    private BigDecimal price;

    @XmlAttribute
    private Integer quantity;
}
