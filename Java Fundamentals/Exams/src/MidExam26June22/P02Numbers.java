package MidExam26June22;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("Finish")) {
            String[] commandLine = commandInput.split(" ");
            String command = commandLine[0];
            int value = Integer.parseInt(commandLine[1]);
            int countFoundNumbers = 0;

            switch (command) {
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    for (int i = 0; i <= numbers.size() - 1; i++) {
                        if (numbers.contains(value)) {
                            numbers.remove(Integer.valueOf(value));
                            break;
                        }
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(commandLine[2]);
                    for (int i = 0; i <= numbers.size() - 1; i++) {
                        if (numbers.contains(value)) {
                            numbers.set(numbers.indexOf(value), replacement);
                            break;
                        }
                    }
                    break;
                case "Collapse":
                    numbers.removeIf(e -> e < value);
                    break;

            }

            commandInput = scanner.nextLine();
        }
        for (int item : numbers) {
            System.out.print(item + " "); }
    }
}
