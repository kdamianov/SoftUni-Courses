package com.example.cardealer.model.dto.customersDto;

import com.example.cardealer.model.entities.Sale;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerBirthdateOrderedDto {

    @Expose
    @SerializedName("Id")
    private Long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("BirthDate")
    private String birthDate;

    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;

    @Expose
    @SerializedName("Sales")
    private List<Sale> sales;

}
