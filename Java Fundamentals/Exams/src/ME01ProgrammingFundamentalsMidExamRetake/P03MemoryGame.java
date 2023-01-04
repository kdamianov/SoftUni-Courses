package ME01ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int countMoves = 0;
        boolean isWon = false;

        while (!input.equals("end")) {
            countMoves ++;
            List<String> indexes = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            int firstIndex = Integer.parseInt(indexes.get(0));
            int secondIndex = Integer.parseInt(indexes.get(1));

            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex > sequence.size() - 1 || secondIndex < 0 || secondIndex > sequence.size() -1) {
                String newElement = "-" + countMoves + "a";
                sequence.add(sequence.size() / 2, newElement);
                sequence.add(sequence.size() / 2 + 1, newElement);
                System.out.println("Invalid input! Adding additional elements to the board");
                input = scanner.nextLine();
                continue;
            }

            if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(firstIndex));
                String elementToRemove = sequence.get(firstIndex);
                sequence.removeAll(Collections.singleton(String.valueOf(elementToRemove)));
            } else {
                System.out.println("Try again!");
            }
            if (sequence.size() == 0) {
                isWon = true;
            }
            if (isWon) {
                System.out.printf("You have won in %d turns!", countMoves);
                break;
            }

            input = scanner.nextLine();
        }
        if (!isWon) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequence));
        }
    }
}
