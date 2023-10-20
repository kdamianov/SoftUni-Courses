package bg.softuni.planer_app.service.impl;

import bg.softuni.planer_app.model.dto.UserLoginBindingModel;
import bg.softuni.planer_app.model.dto.UserRegisterBindingModel;
import bg.softuni.planer_app.model.entity.UserEntity;
import bg.softuni.planer_app.repo.UserRepository;
import bg.softuni.planer_app.service.UserService;
import bg.softuni.planer_app.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder,
                           LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }


    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        // validations: existing username, existing mail, non-matching passwords

        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent() ||
                this.userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        UserEntity user = modelMapper.map(userRegisterBindingModel, UserEntity.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        UserEntity user = userRepository.findByUsername(username).orElse(null);

        if (user != null
                && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())) {

            loggedUser.login(username);

            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
