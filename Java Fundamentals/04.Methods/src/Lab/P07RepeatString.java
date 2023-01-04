package Lab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textInput = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(textInput, n));

    }
    public static String repeatString(String toRepeat, int n) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += toRepeat;
        }
        return result;
    }

}
