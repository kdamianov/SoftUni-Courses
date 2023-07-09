package bg.softuni.automappingobjectsexercise.service.impl;

import bg.softuni.automappingobjectsexercise.model.dto.GamesAllDto;
import bg.softuni.automappingobjectsexercise.model.dto.UserLoginDto;
import bg.softuni.automappingobjectsexercise.model.dto.UserOwnedGames;
import bg.softuni.automappingobjectsexercise.model.dto.UserRegisterDto;
import bg.softuni.automappingobjectsexercise.model.entities.User;
import bg.softuni.automappingobjectsexercise.repository.UserRepository;
import bg.softuni.automappingobjectsexercise.service.UserService;
import bg.softuni.automappingobjectsexercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service //задължителна имплеменатция
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Wrong confirm password!");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violations =
                validationUtil.getViolations(userRegisterDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = mapper.map(userRegisterDto, User.class); //прехвърляме информацията от DTO в User

        long usersCount = userRepository.count(); //Първият регистриран става Admin
        user.setAdmin(usersCount == 0);

        userRepository.save(user); //запазва го в базата
        System.out.printf("%s was registered%n", userRegisterDto.getFullName());


    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations =
                validationUtil.getViolations(userLoginDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = userRepository
                .findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
                .orElse(null);

        if (user == null) {
            System.out.println("Incorrect username / password");
            return;
        }

        loggedInUser = user;
        System.out.printf("Successfully logged in %s%n", user.getFullName());

    }

    @Override
    public void logout() {
        if (loggedInUser == null) {
            System.out.println("Cannot log out. No user was logged in.");
        } else {
            System.out.printf("User %s successfully logged out%n", loggedInUser.getFullName());
            loggedInUser = null;
        }
    }

    @Override
    public User getLoggedInUser() {
        return loggedInUser;
    }


    @Override
    public List<UserOwnedGames> printOwnedGames(User loggedInUser) {
        if (getLoggedInUser() != null) {
            return userRepository.findAllGamesByUser(loggedInUser.getId())
                    .stream()
                    .map(game -> mapper.map(game, UserOwnedGames.class))
                    .toList();
        }
        return null;
    }
}
