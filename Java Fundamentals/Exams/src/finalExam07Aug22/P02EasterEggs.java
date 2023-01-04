package finalExam07Aug22;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([@#]+)(?<color>[a-z]{3,})([@#]+)(\\W+)?\\/+(?<ammount>[0-9]+)(\\/+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = matcher.group("color");
            String ammount = matcher.group("ammount");

            System.out.printf("You found %s %s eggs!%n", ammount, color);
        }
    }
}
