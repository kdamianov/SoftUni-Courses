package FE01ProgrammingFundamentalsFinalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 100/100 В Judge!!!

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(#|\\|)(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,4})\\1";

        List<String> itemInfo = new ArrayList<>();


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int totalCalories = 0;
        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            String calories = matcher.group("calories");

            itemInfo.add(String.format("Item: %s, Best before: %s, Nutrition: %s", itemName, expirationDate, calories));
            int nutrition = Integer.parseInt(calories);
            totalCalories += nutrition;
        }
        int daysToLast = totalCalories/2000;
        System.out.printf("You have food to last you for: %d days!%n", daysToLast);

        itemInfo.forEach(System.out::println);
    }
}
