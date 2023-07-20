package com.example.cardealer.model.dto.salesDto;

import com.example.cardealer.model.dto.carsDto.CarSeedDto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SaleDiscountDto {
    @Expose
    private CarSeedDto car;

    @Expose
    @SerializedName("customerName")
    private String name;

    @Expose
    @SerializedName("Discount")
    private Double discount;

    @Expose
    private BigDecimal price;

    @Expose
    private BigDecimal priceWithDiscount;

}
