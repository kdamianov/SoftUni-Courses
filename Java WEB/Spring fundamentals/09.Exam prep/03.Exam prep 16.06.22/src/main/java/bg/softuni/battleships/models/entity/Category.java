package bg.softuni.battleships.models.entity;

import jakarta.persistence.*;
import bg.softuni.battleships.models.enums.CategoryNameEnum;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    //•	Name
    //  o	An option between BATTLE, CARGO, PATROL
    //  o	The values should be unique in the database
    //•	Description
    //  o	A very long and detailed description of the category
    //  o	Can accept null values
    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true, nullable = false)
    private CategoryNameEnum name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public Category(CategoryNameEnum name) {
        this.name = name;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
