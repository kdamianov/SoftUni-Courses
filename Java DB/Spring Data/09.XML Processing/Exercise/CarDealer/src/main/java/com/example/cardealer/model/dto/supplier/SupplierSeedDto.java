package com.example.cardealer.model.dto.supplier;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedDto {

    @XmlAttribute
    @Size(min = 3)
    private String name;

    @XmlAttribute(name = "is-importer")
    private boolean isImporter;
}
