package com.example.exam_prep_15_10_21.model.entity;

import com.example.exam_prep_15_10_21.model.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryModel extends BaseEntity{
    //•	Has a Name
    //  o	An option between (Coffee, Cake, Drink, Other)
    //•	Has a Needed Time (just an integer)
    //  o	The approximate time in minutes needed for the preparation of a product of the specified category.
    //      	The needed time for a Drink is 1 min.
    //      	The needed time for Coffee is 2 min.
    //      	The needed time for an Other is 5 min.
    //      	The needed time for a Cake is 10 min.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryEnum name;
    @Column(name = "needed_time", nullable = false)
    private Integer neededTime;

    public CategoryModel() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryModel setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public CategoryModel setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
