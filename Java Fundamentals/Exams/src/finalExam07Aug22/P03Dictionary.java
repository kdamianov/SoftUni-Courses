package finalExam07Aug22;

import java.util.*;

public class P03Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordsAndDefinitions = scanner.nextLine();
        String onlyWords = scanner.nextLine();

        Map<String, List<String>> wordsAndDefinitionsMap = new LinkedHashMap<>();

        String[] wordsAndDefinitonsArr = wordsAndDefinitions.split(" \\| ");
        for (String element : wordsAndDefinitonsArr) {
            String word = element.split(": ")[0];
            String definition = element.split(": ")[1];
            if (!wordsAndDefinitionsMap.containsKey(word)) {
                wordsAndDefinitionsMap.put(word, new ArrayList<>());
                wordsAndDefinitionsMap.get(word).add(definition);
                List<String> definitons = new ArrayList<>();
            } else {
                wordsAndDefinitionsMap.get(word).add(definition);
            }
        }
        String[] onlyWordsArr = onlyWords.split(" \\| ");

        String command = scanner.nextLine();
        if (command.equals("Test")) {
            for (String word : onlyWordsArr) {
                if (wordsAndDefinitionsMap.containsKey(word)) {
                    System.out.println(word + ":");
                    wordsAndDefinitionsMap.get(word).forEach(value -> System.out.println(" -" + value));
                }
            }
        } else if (command.contains("Hand Over")) {
            wordsAndDefinitionsMap.entrySet().forEach(key -> System.out.print(key.getKey() + " "));
            System.out.println();
        }
    }
}
