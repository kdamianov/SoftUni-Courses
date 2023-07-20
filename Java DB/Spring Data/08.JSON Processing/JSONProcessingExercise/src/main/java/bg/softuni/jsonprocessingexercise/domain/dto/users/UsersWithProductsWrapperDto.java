package bg.softuni.jsonprocessingexercise.domain.dto.users;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class UsersWithProductsWrapperDto {

    @Expose
    private Integer usersCount;
    @Expose
    private List<UsersWithProductsDto> users;

    public UsersWithProductsWrapperDto(List<UsersWithProductsDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }

}
