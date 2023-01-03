package lab;

import java.util.Scanner;

public class PasswordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPassword = scanner.nextLine();

        String correctPass = "s3cr3t!P@ssw0rd";

        if (inputPassword.equals(correctPass)) {

            System.out.println("Welcome");

        } else {
            System.out.println("Wrong password!");
        }
    }
}
