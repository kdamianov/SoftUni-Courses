package bg.softuni.jsonprocessingexercise.domain.dto.categories;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategorySeedDto {

    @Expose
    @Size(min = 3, max = 15)
    String name;
}
