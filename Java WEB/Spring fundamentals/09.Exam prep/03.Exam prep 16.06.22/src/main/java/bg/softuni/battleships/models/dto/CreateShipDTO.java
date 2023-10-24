package bg.softuni.battleships.models.dto;

import bg.softuni.battleships.models.enums.CategoryNameEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateShipDTO {
    @NotBlank
    @Size(min = 2, max = 10)
    private String name;
    @Positive
    private long power;
    @Positive
    private long health;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate created;

    @Positive                  //избираме, за да покаже дали е избрана дадена категория (0, 1 или 2)
    private int category = -1; //default value is 0

    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public CreateShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getPower() {
        return power;
    }

    public CreateShipDTO setPower(long power) {
        this.power = power;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public CreateShipDTO setHealth(long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CreateShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public int getCategory() {
        return category;
    }

    public int setCategory(int category) {
        this.category = category;
        return this.getCategory();
    }
}
