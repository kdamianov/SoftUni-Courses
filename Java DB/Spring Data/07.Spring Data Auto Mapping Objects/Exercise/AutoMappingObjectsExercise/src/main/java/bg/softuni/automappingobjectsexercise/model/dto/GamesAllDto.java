package bg.softuni.automappingobjectsexercise.model.dto;

import java.math.BigDecimal;

public class GamesAllDto {
    private String title;
    private BigDecimal price;

    public GamesAllDto() {
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
}
