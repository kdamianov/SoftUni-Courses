package exP07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        CustomList<String> list = new CustomList<>();

        while(!command.equals("END")) {
            String[] commandParts = command.split("\\s+");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Add":
                    String elementToAdd = commandParts[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandParts[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToSearch = commandParts[1];
                    System.out.println(list.contains(elementToSearch));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandParts[1]);
                    int secondIndex  = Integer.parseInt(commandParts[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String element = commandParts[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMaximum());
                    break;
                case "Min":
                    System.out.println(list.getMinimum());
                    break;
                case "Sort":
                    SorterClass.sort(list);
                    break;
                case "Print":
                    System.out.println(list.toString());
                    break;

            }


            command = scanner.nextLine();
        }
    }
}
