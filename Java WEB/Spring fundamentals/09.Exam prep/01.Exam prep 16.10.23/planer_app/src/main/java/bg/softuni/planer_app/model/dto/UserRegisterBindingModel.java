package bg.softuni.planer_app.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {
    //•	Has a Username (unique, not null)
    //  o	Username length must be between 3 and 20 characters (inclusive of 3 and 20).
    //•	Has a Password (not null)
    //  o	Password length must be between 3 and 20 characters (inclusive of 3 and 20).
    //•	Has an Email (unique, not null)
    //  o	Must contain '@'.
    //•	Has assignedTasks
    //  o	The assignedTasks is a collection that contains users tasks that are assigned to him.
    //      One user may have many tasks and one task can be assigned to only one user.

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;
    @NotBlank(message = "Email cannot be empty!")
    private String email;
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
