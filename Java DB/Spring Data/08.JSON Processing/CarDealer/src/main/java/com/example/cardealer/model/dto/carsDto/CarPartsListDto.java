package com.example.cardealer.model.dto.carsDto;

import com.example.cardealer.model.dto.partsDto.PartNameAndPriceDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CarPartsListDto {

    @Expose
    private CarSeedDto car;

    @Expose
    private Set<PartNameAndPriceDto> parts;
}
