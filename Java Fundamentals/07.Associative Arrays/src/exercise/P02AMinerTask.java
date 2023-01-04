package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        Map<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourcesMap.containsKey(input)) {
                resourcesMap.put(input, quantity);
            } else {
                resourcesMap.put(input, resourcesMap.get(input) + quantity);
            }

            input = scanner.nextLine();
        }
        resourcesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
