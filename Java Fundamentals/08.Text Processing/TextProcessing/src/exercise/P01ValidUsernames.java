package exercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //sh, too_long_username, !lleg@l ch@rs, jeffbutt
        String[] usernames = input.split(", ");
        //{sh}, [too_long_username], [!lleg@l ch@rs], [jeffbutt]
        //проверка дали е валиден username:
        //•	Has a length between 3 and 16 characters.
        //•	Contains only letters, numbers, hyphens, and underscores.

        for (String username : usernames) {
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }

    }
    //метод за проверка дали е валиден
    public static boolean isValidUsername (String username) {
        //валидна дължина и съдържание
        if (username.length() <3 || username.length() > 16) {
            return false;
        }
        for (char symbol: username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '_' && symbol != '-') {
                return false;
            }
        }
        return true;
    }
}
