package bg.softuni.jsonprocessingexercise.domain.dto.products;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductSeedDto {

    @Expose
    @Size(min = 3)
    private String name;

    @Expose
    // @Positive --> Zero excluded
    private BigDecimal price;

}
