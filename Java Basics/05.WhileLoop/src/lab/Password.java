package lab;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String userPass = scanner.nextLine();

        String currentPass = scanner.nextLine();
        while (!currentPass.equals(userPass)) {
            currentPass = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", username);
    }
}
