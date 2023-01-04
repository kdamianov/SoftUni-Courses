package Lab;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();


        while (!input.equals("end")) {
            List <String> commandLine= Arrays.stream(input.split(" ")).collect(Collectors.toList());
            int element = 0;
            String command ="";
            String secondCommand = "";
            if (commandLine.contains("Contains")) {
                command = commandLine.get(0);
                element = Integer.parseInt(commandLine.get(1));
                if (numList.contains(element)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            }else if (commandLine.contains("Print")) {
                command = commandLine.get(0);
                secondCommand = commandLine.get(1);

                if (secondCommand.contains("even")) {
                    for (int i = 0; i < numList.size(); i++) {
                        if (numList.get(i) % 2 == 0) {
                            System.out.print(numList.get(i) + " ");
                        }
                    }
                    System.out.println();
                }else {
                    for (int i = 0; i < numList.size(); i++) {
                        if (numList.get(i) % 2 !=0) {
                            System.out.print(numList.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            } else if (commandLine.contains("Get")) {
                secondCommand = commandLine.get(1);
                int sumElements = 0;
                for (int i = 0; i < numList.size(); i++) {
                    sumElements += numList.get(i);
                }
                System.out.println(sumElements);
            } else if (commandLine.contains("Filter")) {
                element = Integer.parseInt(commandLine.get(2));
                secondCommand = commandLine.get(1);
                switch (secondCommand) {
                    case "<":
                        for (Integer el : numList) {
                            if (el < element) {
                                System.out.print(el + " ");
                            }
                        }
                        System.out.println();
                        break;
                    case ">":
                        for (Integer el : numList) {
                            if (el > element) {
                                System.out.print(el + " ");
                            }
                        }
                        System.out.println();
                        break;
                    case ">=":
                        for (Integer el : numList) {
                            if (el >= element) {
                                System.out.print(el + " ");
                            }
                        }
                        System.out.println();
                        break;
                    case "<=":
                        for (Integer el : numList) {
                            if (el <= element) {
                                System.out.print(el + " ");
                            }
                        }
                        System.out.println();
                        break;
                }
            }

            input = scanner.nextLine();
        }
    }
}
