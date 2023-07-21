package com.example.cardealer.model.dto.cars;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarSeedDto {

    @XmlElement
    @Size(min = 3)
    private String make;
    @XmlElement
    private String model;
    @XmlElement(name = "travelled-distance")
    private BigInteger travelledDistance;
}
