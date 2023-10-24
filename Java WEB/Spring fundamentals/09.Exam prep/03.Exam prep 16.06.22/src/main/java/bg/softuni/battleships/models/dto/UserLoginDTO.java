package bg.softuni.battleships.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    @Size(min = 3, max = 10)
    @NotBlank
    private String userName;
    @Size(min = 3)
    @NotBlank
    private String password;

    public UserLoginDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public UserLoginDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
