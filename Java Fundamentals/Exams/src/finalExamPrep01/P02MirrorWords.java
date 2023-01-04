package finalExamPrep01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //намираме 2ка думи, които са огледални
        String regex = "(@|#)(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> pairs = new ArrayList<>();

        int countAllPairs = 0;

        while (matcher.find()) {
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            countAllPairs++;

            //проверка дали е огледална
            StringBuilder secondWordBuilder = new StringBuilder(secondWord);
            String reversedSecond = secondWordBuilder.reverse().toString();
            if (firstWord.equals(reversedSecond)) {
                pairs.add(firstWord + " <=> " + secondWord);
            }
        }
        //отпечатваме брой намерени двойки
        if (countAllPairs == 0){
            System.out.println("No word pairs found!");
        }else {
            System.out.println(countAllPairs + " word pairs found!");
        }


        //отпеатваме само валидни двойки
        if (pairs.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairs));
        }

    }
}
