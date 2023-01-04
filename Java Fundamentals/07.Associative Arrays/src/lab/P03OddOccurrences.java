package lab;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineInput = scanner.nextLine().split(" ");
        Map<String, Integer> wordsCountMap = new LinkedHashMap<>();

        for (int i = 0; i < lineInput.length; i++) {
            String currentWord = lineInput[i].toLowerCase();

            Integer count = wordsCountMap.get(currentWord);

            if (wordsCountMap.containsKey(currentWord)) { //ако съществува увеличваме брояча
                wordsCountMap.put(currentWord,count + 1);
            } else {
                wordsCountMap.put(currentWord, 1); //ако не съществува, слагаме стойност 1
            }
        }

        List<String> oddWords = new ArrayList<>(); //създаваме нов списък за нечетните появявания
        for (Map.Entry<String, Integer> entry : wordsCountMap.entrySet()) { //проверка за нечетни появявания
            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey()); //добавяме в списъка
            }
        }
        System.out.println(String.join(", ", oddWords)); //принтираме по този начин

    }
}
