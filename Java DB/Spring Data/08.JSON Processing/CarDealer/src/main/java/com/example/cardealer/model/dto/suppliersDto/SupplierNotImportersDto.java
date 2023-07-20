package com.example.cardealer.model.dto.suppliersDto;

import com.example.cardealer.model.entities.Part;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SupplierNotImportersDto {
    @Expose
    @SerializedName("Id")
    private Long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    private Integer partsCount;
}
