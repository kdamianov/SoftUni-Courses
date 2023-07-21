package com.example.cardealer.model.dto.supplier;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierLocalDto {
    @XmlAttribute
    private Long id;

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "parts-count")
    private Integer partsCount;
}
