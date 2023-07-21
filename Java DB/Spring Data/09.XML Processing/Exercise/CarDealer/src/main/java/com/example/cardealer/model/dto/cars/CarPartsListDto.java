package com.example.cardealer.model.dto.cars;

import com.example.cardealer.model.dto.parts.PartNameAndPriceRootDto;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarPartsListDto {
    @XmlAttribute
    private String make;
    @XmlAttribute
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;
    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
    private Set<PartNameAndPriceRootDto> parts;
}
