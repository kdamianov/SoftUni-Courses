package com.example.cardealer.model.dto.cars;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarBasicInfoDto {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;
}
