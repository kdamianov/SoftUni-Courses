package bg.softuni.jsonprocessingexercise.domain.dto.products;

import bg.softuni.jsonprocessingexercise.domain.dto.categories.CategoryDto;
import bg.softuni.jsonprocessingexercise.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @Expose
    private String name;
    @Expose

    private BigDecimal price;
    @Expose

    private User seller;
    @Expose

    private User buyer;
    @Expose

    private Set<CategoryDto> categories;


}
