package bg.softuni.jsonprocessingexercise.domain.dto.users;

import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductWithBuyerDto;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class UserSoldDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductWithBuyerDto> soldProducts;

}
