import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Judge: 100/100

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(c -> vowelsQueue.offer(c.charAt(0)));

        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(c -> consonantsStack.push(c.charAt(0)));

        String[] words = new String[] {"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[] {"----", "-----", "----", "-----"};

        while(!consonantsStack.isEmpty()) {
            char currentVowel = vowelsQueue.pop();
            char currentConsonant = consonantsStack.pop();

            for (int i = 0; i < words.length; i++) {
                String searchedWord = words[i];
                int vowelIndex = searchedWord.indexOf(currentVowel);
                int consonantIndex = searchedWord.indexOf(currentConsonant);

                if (vowelIndex >= 0) {
                    foundWords[i] = foundWords[i].substring(0, vowelIndex) + currentVowel + foundWords[i].substring(vowelIndex + 1);
                }
                if (consonantIndex >= 0) {
                    foundWords[i] = foundWords[i].substring(0, consonantIndex) + currentConsonant + foundWords[i].substring(consonantIndex + 1);
                }
            }
            vowelsQueue.offer(currentVowel);
        }
        List<String> completeWords = Arrays.stream(foundWords).filter(w -> !w.contains("-")).collect(Collectors.toList());

        System.out.printf("Words found: %d%n", completeWords.size());
        completeWords.forEach(System.out::println);
    }
}
