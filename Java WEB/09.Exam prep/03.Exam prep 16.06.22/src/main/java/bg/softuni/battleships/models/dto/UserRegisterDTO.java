package bg.softuni.battleships.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    //•	Username
    //  o	The length of the values should be between 3 and 10 characters long (both numbers are INCLUSIVE)
    //  o	The values should be unique in the database
    //•	Full Name
    //  o	The length of the values should be between 5 and 20 characters long (both numbers are INCLUSIVE)
    //•	Password
    //  o	The length of the values should be more than 3 characters long (INCLUSIVE)
    //•	Email
    //  o	The values should contain a '@' symbol
    //  o	The values should be unique in the database

    @Size(min = 3, max = 10)
    @NotBlank
    private String username;
    @Size(min = 5, max = 20)
    @NotBlank
    private String fullName;
    @Email
    @NotBlank
    private String email;
    @Size(min = 3)
    @NotBlank
    private String password;
    @Size(min = 3)
    @NotBlank
    private String confirmPassword;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
