package ME05ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] commandLine = input.split(" - ");
            String command = commandLine[0];
            String item = commandLine[1];

            switch (command) {
                case "Collect":
                    if (!items.contains(item)) {
                        items.add(item);
                    } else {
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Drop":
                    if (items.contains(item)) {
                        items.remove(item);
                    }
                    break;
                case "Combine Items":
                    String[] combinedItems = item.split(":");
                    String oldItem = combinedItems[0];
                    String newItem = combinedItems[1];

                    if (items.contains(oldItem)) {
                        items.add(items.indexOf(oldItem) + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(item)) {
                        String currentItem = String.valueOf(items.indexOf(item));
                        items.remove(items.indexOf(item));
                        items.add(item);

                    }
                    break;
            }



            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", items));
    }
}
