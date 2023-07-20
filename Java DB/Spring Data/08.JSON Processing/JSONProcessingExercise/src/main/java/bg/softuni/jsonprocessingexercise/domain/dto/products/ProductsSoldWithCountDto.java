package bg.softuni.jsonprocessingexercise.domain.dto.products;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductsSoldWithCountDto {
    @Expose
    private Integer count;
    @Expose
    private List<ProductsBasicInfoDto> products;

}
