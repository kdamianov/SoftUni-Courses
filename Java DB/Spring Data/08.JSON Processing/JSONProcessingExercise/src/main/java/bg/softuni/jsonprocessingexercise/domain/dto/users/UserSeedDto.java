package bg.softuni.jsonprocessingexercise.domain.dto.users;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSeedDto {

    @Expose
    private String firstName;

    @Expose
    @Size(min = 3)
    private String lastName;

    @Expose
    private Integer age;

}
