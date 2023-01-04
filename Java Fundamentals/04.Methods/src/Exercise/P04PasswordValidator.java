package Exercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input  = scanner.nextLine();

        if (!isValidLength(input)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidContent(input)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValidCountDigits(input)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isValidLength(input) && isValidContent(input) && isValidCountDigits(input)) {
            System.out.println("Password is valid");
        }
    }
    private static boolean isValidLength (String password) {
        return password.length() >= 6 && password.length() <=10;
        // може и с if проверки
    }
    private static boolean isValidContent (String password) {
        for (char symbol: password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
    private static boolean isValidCountDigits (String password) {
        int count = 0;
        for (char symbol: password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                count ++;
            }
        }
//        if (count >= 2) {
//            return true;
//        } else {
//            return false;
//        }
        return count >= 2;
    }
}
