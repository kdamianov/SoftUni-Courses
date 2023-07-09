package bg.softuni.automappingobjectsexercise;

import bg.softuni.automappingobjectsexercise.model.dto.GameAddDto;
import bg.softuni.automappingobjectsexercise.model.dto.UserLoginDto;
import bg.softuni.automappingobjectsexercise.model.dto.UserRegisterDto;
import bg.softuni.automappingobjectsexercise.model.entities.User;
import bg.softuni.automappingobjectsexercise.service.GameService;
import bg.softuni.automappingobjectsexercise.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import static java.util.stream.Collectors.toList;

@Component //задължително се анотира!!!
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final BufferedReader reader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Enter your command: ");
            String[] commands = reader.readLine().split("\\|");
            switch (commands[0]) { //внимава се с casing или се дава .toLowerCase()
                case "RegisterUser" -> userService
                        .registerUser(new UserRegisterDto(commands[1], commands[2],
                                commands[3], commands[4]));
                case "LoginUser" -> userService
                        .loginUser(new UserLoginDto(commands[1], commands[2]));
                case "Logout" -> userService
                        .logout();
                case "AddGame" -> gameService
                        .addGame(new GameAddDto(commands[1], new BigDecimal(commands[2]),
                                Double.parseDouble(commands[3]),
                                commands[4], commands[5], commands[6], commands[7]));
                case "EditGame" -> gameService
                        .editGame(Long.parseLong(commands[1]),
                                new BigDecimal(commands[2].split("=")[1]),
                                Double.parseDouble(commands[3].split("=")[1]));
                case "DeleteGame" -> gameService
                        .deleteGame(Long.parseLong(commands[1]));
                case "AllGames" -> gameService
                        .printAllGames()
                        .stream()
                        .map(allGamesDto -> String.format("%s %.2f", allGamesDto.getTitle(), allGamesDto.getPrice()))
                        .toList()
                        .forEach(System.out::println);
                case "DetailGame" -> System.out.println(gameService
                        .printGameDetails(commands[1]));
                case "OwnedGames" -> {
                    if (userService.getLoggedInUser() == null) {
                        System.out.println("No logged in user!");
                        return;
                    } else {
                        userService
                                .printOwnedGames(userService.getLoggedInUser())
                                .stream()
                                .map(userOwnedGames -> String.format("%s", userOwnedGames.getTitle()))
                                .toList()
                                .forEach(System.out::println);
                    }
                }
            }
        }
    }

}
