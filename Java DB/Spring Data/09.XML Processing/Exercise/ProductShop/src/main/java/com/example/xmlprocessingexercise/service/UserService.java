package com.example.xmlprocessingexercise.service;

import com.example.xmlprocessingexercise.model.dto.users.UserSeedDto;
import com.example.xmlprocessingexercise.model.dto.users.UserViewRootDto;
import com.example.xmlprocessingexercise.model.dto.users.UserWrapperDto;
import com.example.xmlprocessingexercise.model.entities.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UserViewRootDto findAllUsersWithMoreThanOneSoldProducts();


    @Transactional
    UserWrapperDto getUsersWithSoldProductsWrapper();
}
