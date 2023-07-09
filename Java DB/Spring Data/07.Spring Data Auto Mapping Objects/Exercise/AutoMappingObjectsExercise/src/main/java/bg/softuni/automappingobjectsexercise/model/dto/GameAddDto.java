package bg.softuni.automappingobjectsexercise.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    @Pattern(regexp = "[A-Z][a-z]{6,100}", message = "Enter a valid title!")
    private String title;
    //@Min(0)
    @DecimalMin(value = "0",message = "Enter a valid price!")//може едното и другото
    private BigDecimal price;
    //@Min(0)
    @Positive(message = "Enter a valid size!")
    private Double size;
    @Size(min = 11, max = 11, message = "Enter a valid trailer!") //Може и regex
    private String trailer;
    @Pattern(regexp = "(https?).+", message = "Enter a valid thumbnailURL!")
    private String thumbnailURL;
    @Size(min = 20, message = "Enter a valid description!")
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size,
                      String trailer, String thumbnailURL, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
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
}
