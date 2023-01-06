package exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> symbolMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!symbolMap.containsKey(currentChar)) {
                symbolMap.put(currentChar, 1);
            } else {
                int currentOccurrences = symbolMap.get(currentChar);
                symbolMap.put(currentChar, currentOccurrences + 1);
            }


        }
        symbolMap.entrySet().forEach(e -> System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue()));
    }
}
