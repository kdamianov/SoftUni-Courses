package com.example.cardealer.model.dto.customersDto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CustomerSeedDto {
    @Expose
    @Size(min = 3)
    private String name;

    @Expose
    @NotBlank
    private LocalDateTime birthDate;

    @Expose
    private boolean isYoungDriver;

}
