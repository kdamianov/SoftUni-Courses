package bg.softuni.jsonprocessingexercise.service.impl;

import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductWithBuyerDto;
import bg.softuni.jsonprocessingexercise.domain.dto.users.*;
import bg.softuni.jsonprocessingexercise.domain.entities.User;
import bg.softuni.jsonprocessingexercise.repositories.UserRepository;
import bg.softuni.jsonprocessingexercise.service.UserService;
import bg.softuni.jsonprocessingexercise.util.ValidationUtil;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static bg.softuni.jsonprocessingexercise.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {
    private static final String USERS_FILE_NAME = "users.json";
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() == 0) {
            Arrays.stream(gson.fromJson(
                            Files.readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_NAME)),
                            UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }


    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom //по този начин взимаме Random id
                .current().nextLong(1, userRepository.count() + 1);

        return userRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct() {
        return userRepository.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenByFirstName()
                .stream()
                .map(user -> {
                    UserSoldDto userSoldDto = modelMapper.map(user, UserSoldDto.class);
                    Set<ProductWithBuyerDto> products = userSoldDto.getSoldProducts().stream()
                            .filter(productWithBuyerDto -> productWithBuyerDto.getBuyerLastName() != null)
                            .collect(Collectors.toSet());
                    userSoldDto.setSoldProducts(products);
                    return userSoldDto;
                })
                .toList();
    }

    @Override
    @Transactional
    public UsersWithProductsWrapperDto getUsersWithSoldProductsWrapper() {
        List<User> usersSummary = userRepository
                .findAllUsersWithMoreThanOneSoldProductOrderByProductsCountDescThenByLastName();

        List<UsersWithProductsDto> usersWithSoldProducts = usersSummary.stream()
                .map(user -> {
                    UsersWithProductsDto usersWithProductsDto = modelMapper.map(user, UsersWithProductsDto.class);
                    usersWithProductsDto.getSoldProducts().setCount(user.getSoldProducts().size());

                    return usersWithProductsDto;
                })
                .toList();


        return new UsersWithProductsWrapperDto(usersWithSoldProducts);
    }


}
