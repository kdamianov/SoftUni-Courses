package bg.softuni.planer_app.service.impl;

import bg.softuni.planer_app.model.dto.UserRegisterBindingModel;
import bg.softuni.planer_app.model.entity.UserEntity;
import bg.softuni.planer_app.repo.UserRepository;
import bg.softuni.planer_app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

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
}
