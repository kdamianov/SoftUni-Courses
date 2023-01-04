package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();

        for (char symbol: text.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            //ако не се е срещал символът
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1);
            } //ако го има символът
            else {
                int currentCount = symbolsCount.get(symbol);
                symbolsCount.put(symbol, currentCount + 1);
            }
        }
        //symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        symbolsCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
