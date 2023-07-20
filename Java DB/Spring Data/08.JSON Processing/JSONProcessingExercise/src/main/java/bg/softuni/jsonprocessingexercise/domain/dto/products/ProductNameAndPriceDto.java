package bg.softuni.jsonprocessingexercise.domain.dto.products;

import bg.softuni.jsonprocessingexercise.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductNameAndPriceDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @Expose
    private String seller;
}
