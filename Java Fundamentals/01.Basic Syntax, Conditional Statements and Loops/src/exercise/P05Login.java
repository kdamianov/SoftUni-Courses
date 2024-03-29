package exercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int position = username.length() - 1; position >= 0 ; position--) {
            char currSymbol = username.charAt(position);
            password += currSymbol;
        }
        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals(password)) {
            counter ++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }

            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
        }
        if (input.equals(password)){
        System.out.printf("User %s logged in.", username);
        }
    }
}
