package com.example.springdataintro;

import com.example.springdataintro.models.User;
import com.example.springdataintro.services.AccountService;
import com.example.springdataintro.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private AccountService accountService;
    private UserService userService;

    public ConsoleRunner(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User newUser = new User("Stavri", 57);

        userService.registerUser(newUser);
    }
}
