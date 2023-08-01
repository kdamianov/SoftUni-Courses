package softuni.exam.models.dto;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConstellationImportDto {
    //•	name – accepts char sequence (between 3 to 20 inclusive). The values are unique in the database.
    //•	description - accepts char sequence about the naming of the constellation with a character length value higher than or equal to 5.
    //•	stars – a collection of all stars that are part the constellation
    //•	Constraint: The constellations table has a relation with the stars table.
    @Expose
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Expose
    @NotNull
    @Size(min = 5)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
