package ME04ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList= Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("Go Shopping!")) {
            String[] commandLine = commandInput.split(" ");
            String command = commandLine[0];
            String item = commandLine[1];

            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(item)) {
                        shoppingList.remove(item);
                    }
                    break;
                case "Correct":
                    String secondItem = commandLine[2];
                    if (shoppingList.contains(item)) {
                        shoppingList.set(shoppingList.indexOf(item), secondItem);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(item)) {
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                    break;
            }


            commandInput = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));
    }
}
