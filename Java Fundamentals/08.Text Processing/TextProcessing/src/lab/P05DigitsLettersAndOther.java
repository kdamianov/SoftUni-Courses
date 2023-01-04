package lab;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder digitString = new StringBuilder();
        StringBuilder letterString = new StringBuilder();
        StringBuilder otherString = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (Character.isDigit(symbol)) {
                digitString.append(symbol);
            } else if (Character.isLetter(symbol)) {
                letterString.append(symbol);
            } else {
                otherString.append(symbol);
            }
        }

        System.out.println(digitString);
        System.out.println(letterString);
        System.out.println(otherString);
    }
}
