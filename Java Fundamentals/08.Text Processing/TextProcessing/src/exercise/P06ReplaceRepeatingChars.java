package exercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = "";

        char firstOccur = input.charAt(0);
        result += firstOccur;

        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != firstOccur) {
                result += currentSymbol;
                firstOccur = currentSymbol;
            }

        }

        System.out.println(result);
    }
}
