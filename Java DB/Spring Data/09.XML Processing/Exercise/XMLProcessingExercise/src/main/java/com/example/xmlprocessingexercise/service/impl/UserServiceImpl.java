package com.example.xmlprocessingexercise.service.impl;

import com.example.xmlprocessingexercise.model.dto.users.*;
import com.example.xmlprocessingexercise.model.entities.User;
import com.example.xmlprocessingexercise.repositories.UserRepository;
import com.example.xmlprocessingexercise.service.UserService;
import com.example.xmlprocessingexercise.util.ValidationUtil;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        if (userRepository.count() == 0) {
            users
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current()
                .nextLong(1, userRepository.count() + 1);

        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserViewRootDto findAllUsersWithMoreThanOneSoldProducts() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();
        userViewRootDto.setProducts(userRepository
                .findAllWithMoreThanOneSoldProduct()
                .stream()
                .map(user -> modelMapper.map(user, UserWithProductsDto.class))
                .collect(Collectors.toList()));

        return userViewRootDto;
    }

    @Override
    @Transactional
    public UserWrapperDto getUsersWithSoldProductsWrapper() {
        List<User> usersSummary = userRepository
                .findAllUsersWithMoreThaneOneSoldProductDetailedInfo();

        List<UsersWithProductsDto> usersWithSoldProducts = usersSummary.stream()
                .map(user -> {
                    UsersWithProductsDto usersWithProductsDto = modelMapper.map(user, UsersWithProductsDto.class);
                    usersWithProductsDto.getSoldProducts().setCount(user.getSoldProducts().size());

                    return usersWithProductsDto;
                })
                .toList();


        return new UserWrapperDto(usersWithSoldProducts);
    }
}
