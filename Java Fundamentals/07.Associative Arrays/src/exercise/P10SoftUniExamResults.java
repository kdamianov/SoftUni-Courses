package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> studentResultsMap = new LinkedHashMap<>();
        Map<String, Integer> languageSubmissionsMap = new LinkedHashMap<>();

        while (!input.equals("exam finished")){
            //"{username}-{language}-{points}" - 3 елемента
            //"{username}-banned" - 2 елемента
            String[] commandInput = input.split("-");
            String user = commandInput[0];
            if (commandInput.length == 3) {
                String language = commandInput[1];
                int points = Integer.parseInt(commandInput[2]);

                //ако няма такъв студент
                if (!studentResultsMap.containsKey(user)) {
                    studentResultsMap.put(user, points);
                } else {
                    int currentPoints = studentResultsMap.get(user);
                    if (points > currentPoints) {
                        studentResultsMap.put(user, points);
                    }
                }

                if (!languageSubmissionsMap.containsKey(language)) {
                    languageSubmissionsMap.put(language, 1);
                } else {
                    languageSubmissionsMap.put(language, languageSubmissionsMap.get(language) + 1);
                }

            } else {
                studentResultsMap.remove(user);
            }



            input = scanner.nextLine();
        }
        System.out.println("Results: ");
        studentResultsMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
        System.out.println("Submissions: ");
        languageSubmissionsMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
