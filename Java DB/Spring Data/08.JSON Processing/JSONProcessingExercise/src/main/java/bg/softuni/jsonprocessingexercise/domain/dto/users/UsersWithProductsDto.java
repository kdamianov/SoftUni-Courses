package bg.softuni.jsonprocessingexercise.domain.dto.users;

import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductsSoldWithCountDto;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class UsersWithProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private ProductsSoldWithCountDto soldProducts;

    public UsersWithProductsDto(ProductsSoldWithCountDto soldProducts) {
        this.soldProducts = new ProductsSoldWithCountDto();
    }
}
