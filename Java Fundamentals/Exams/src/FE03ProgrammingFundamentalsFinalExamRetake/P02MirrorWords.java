package FE03ProgrammingFundamentalsFinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        //#wordOne##wordTwo# - correct match
        String regex = "(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";

        List<String> wordPairsList = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int pairsCount = 0;

        while (matcher.find()) {
            String first = matcher.group("first");
            String second = matcher.group("second");

            pairsCount ++;

            StringBuilder secondWordBuilder = new StringBuilder(second);
            String reversedSecond = secondWordBuilder.reverse().toString();

            if (first.equals(reversedSecond)) {
                wordPairsList.add(first + " <=> " + second);
            }

        }
        if (pairsCount == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", pairsCount);
        }
        if (wordPairsList.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.printf("The mirror words are:%n%s%n", String.join(", ", wordPairsList));
        }
    }
}
