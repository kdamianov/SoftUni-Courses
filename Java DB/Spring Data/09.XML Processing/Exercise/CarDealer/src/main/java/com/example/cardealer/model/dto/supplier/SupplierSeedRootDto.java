package com.example.cardealer.model.dto.supplier;

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

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRootDto {
    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> suppliers;
}
