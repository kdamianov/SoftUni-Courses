package com.example.cardealer.model.dto.partsDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PartNameAndPriceDto {
    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("Price")
    private BigDecimal price;
}
