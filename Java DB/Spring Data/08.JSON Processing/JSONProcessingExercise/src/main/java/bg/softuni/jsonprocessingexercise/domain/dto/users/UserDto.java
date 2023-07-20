package bg.softuni.jsonprocessingexercise.domain.dto.users;

import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductDto;
import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductsBasicInfoDto;
import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductsSoldWithCountDto;
import bg.softuni.jsonprocessingexercise.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private Set<ProductDto> sellingProducts;






}
