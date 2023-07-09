package bg.softuni.automappingobjectsexercise.model.dto;

import java.math.BigDecimal;

public class GameDetailDto {
    private String title;
    private BigDecimal price;
    private String description;
    private String releaseDate;

    public GameDetailDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Title: %s%n" +
                "Price: %.2f%n" +
                "Description: %s%n" +
                "Release date: %s%n",
                this.title, this.price, this.description, this.releaseDate);
    }
}
