package com.example.cardealer.model.dto.partsDto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PartSeedDto {
    @Expose
    @Size(min = 3)
    private String name;
    @Expose
    @Positive
    private BigDecimal price;
    @Expose
    private Integer quantity;
}
