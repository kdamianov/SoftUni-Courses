package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            List <String> commandLine = Arrays.stream(command.split(" ")).collect(Collectors.toList());

            if (command.contains("Add")) {
                //add number at the end
                int numToAdd = Integer.parseInt(commandLine.get(1));
                numbers.add(numToAdd);

            }else if (command.contains("Insert")) {
                //insert number at given index
                int numToInsert = Integer.parseInt(commandLine.get(1));
                int index = Integer.parseInt(commandLine.get(2));

                if (isValid(index, numbers.size())) {
                    numbers.add(index, numToInsert);
                }else {
                    System.out.println("Invalid index");
                }

            }else if (command.contains("Remove")) {
                //remove that indexToRemove
                int indexToRemove = Integer.parseInt(commandLine.get(1));

                if (isValid(indexToRemove, numbers.size())) {
                    numbers.remove(indexToRemove);
                }else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left ")) {
                //first number becomes last 'count' times
                int countLeft = Integer.parseInt(commandLine.get(2));
                //повтаряме countLef- на брой пъти
                for (int time = 1; time <= countLeft; time++) {
                    int firstNum = numbers.get(0);
                    numbers.add(firstNum);
                    numbers.remove(0);
                }

            } else if (command.contains("Shift right ")) {
                //last number becomes first 'count' times
                int countRight = Integer.parseInt(commandLine.get(2));
                ////повтаряме countRight- на брой пъти
                for (int time = 1; time <= countRight; time++) {
                    int lastNum = numbers.get(numbers.size() - 1);

                    numbers.add(0, lastNum);
                    numbers.remove(numbers.size() - 1);
                }
            }

            command = scanner.nextLine();
        }
        for (Integer element : numbers) {
            System.out.print(element + " ");
        }
    }
    //Метод, който валидира индекса на елемента
    public static boolean isValid (int index, int lengthList) {
        return index >=0 && index <=lengthList - 1;
    }
}
