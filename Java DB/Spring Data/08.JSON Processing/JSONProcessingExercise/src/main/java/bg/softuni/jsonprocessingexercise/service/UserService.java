package bg.softuni.jsonprocessingexercise.service;

import bg.softuni.jsonprocessingexercise.domain.dto.users.UserSoldDto;
import bg.softuni.jsonprocessingexercise.domain.dto.users.UsersWithProductsWrapperDto;
import bg.softuni.jsonprocessingexercise.domain.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct();

    UsersWithProductsWrapperDto getUsersWithSoldProductsWrapper();
}
