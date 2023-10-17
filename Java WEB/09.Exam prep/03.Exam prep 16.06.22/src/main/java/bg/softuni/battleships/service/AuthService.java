package bg.softuni.battleships.service;

import bg.softuni.battleships.models.dto.UserLoginDTO;
import bg.softuni.battleships.models.dto.UserRegisterDTO;
import bg.softuni.battleships.models.entity.User;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private final LoggedUser userSession;

    public AuthService(UserRepository userRepository,
                       LoggedUser userSession) {
        this.userRepository = userRepository;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDTO userRegisterDTO) {

        //compare two password fields
        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }

        //check duplicate email
        Optional<User> byEmail = this.userRepository.findByEmail(userRegisterDTO.getEmail());

        if (byEmail.isPresent()) {
            return false;
        }

        //check duplicate username
        Optional<User> byUsername = this.userRepository.findByUsername(userRegisterDTO.getUsername());

        if (byUsername.isPresent()) {
            return false;
        }


        User user = new User();
        user
                .setUsername(userRegisterDTO.getUsername())
                .setFullName(userRegisterDTO.getFullName())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(userRegisterDTO.getPassword());

        this.userRepository.save(user);

        return true;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(userLoginDTO.getUserName(), userLoginDTO.getPassword());

        //not existent user
        if(user.isEmpty()) {
            return false;
        }

        //login
        this.userSession.login(user.get());

        return true;
    }
}
