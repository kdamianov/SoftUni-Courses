package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.StarType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarImportDto {
    //•	name - accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
    //•	light years - The distance from Earth in light years. Accepts only positive number.
    //•	description - a long and detailed description about the star with a character length value higher than or equal to 6.
    //•	star type - categorization of the stars. Ordinal enumeration, one of the following – RED_GIANT, WHITE_DWARF, NEUTRON_STAR
    //•	observers – a collection with all the astronomers that are studying the star.
    //•	Constraint: The stars table has a relation with the constellations table.
    //•	Constraint: The stars table has a relation with the astronomers table.
    @Expose
    @Size(min = 6)
    private String description;
    @Expose
    @Positive
    private Double lightYears;
    @Expose
    @Size(min = 2, max = 30)
    private String name;
    @Expose
    private String starType;
    @Expose
    @NotNull
    private Long constellation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
