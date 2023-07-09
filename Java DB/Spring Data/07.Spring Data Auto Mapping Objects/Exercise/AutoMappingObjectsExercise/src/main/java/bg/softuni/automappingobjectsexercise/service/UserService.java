package bg.softuni.automappingobjectsexercise.service;

import bg.softuni.automappingobjectsexercise.model.dto.UserLoginDto;
import bg.softuni.automappingobjectsexercise.model.dto.UserOwnedGames;
import bg.softuni.automappingobjectsexercise.model.dto.UserRegisterDto;
import bg.softuni.automappingobjectsexercise.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
    User getLoggedInUser();

    List<UserOwnedGames> printOwnedGames(User loggedInUser);
}
