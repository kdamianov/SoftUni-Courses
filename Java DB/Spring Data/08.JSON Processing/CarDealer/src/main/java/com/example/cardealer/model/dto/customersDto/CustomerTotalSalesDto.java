package com.example.cardealer.model.dto.customersDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CustomerTotalSalesDto {
    @Expose
    @SerializedName("fullName")
    private String name;

    @Expose
    private int boughtCars;

    @Expose
    private BigDecimal spentMoney;
}
