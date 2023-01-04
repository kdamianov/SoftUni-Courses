package ME03ProgrammingFundamentalsMidExamRetake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetNumbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {
            String[] commandLine = inputLine.split(" ");
            String command = commandLine[0];
            int index = Integer.parseInt(commandLine[1]);
            int value = Integer.parseInt(commandLine[2]);

            switch (command) {
                case "Shoot":
                    if (isValidIndex(targetNumbers, index)) {
                        int currentNum = targetNumbers.get(index);
                        currentNum = currentNum - value;
                        if (currentNum <= 0) {
                            targetNumbers.remove(index);
                        } else {
                            targetNumbers.set(index, currentNum);
                        }
                    }
                    break;
                case "Add":
                    if (isValidIndex(targetNumbers, index)) {
                        targetNumbers.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    boolean validIndexRadius = targetNumbers.size() - 1 >= index
                            && targetNumbers.size() - 1 >= index + value
                            && index - value >= 0;
                    if (validIndexRadius) {
                        int radius = value * 2 + 1;
                        for (int i = 0; i < radius; i++) {
                            targetNumbers.remove(index - value);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }


            inputLine = scanner.nextLine();

        }
        List <String> resultList = new ArrayList<>();
        for (Integer target : targetNumbers) {
            resultList.add(String.valueOf(target));

        }
        System.out.println(String.join("|", resultList));
    }
    public static boolean isValidIndex (List<Integer> list, int index) {
        return index <= list.size() - 1  && index >= 0;
    }
}

