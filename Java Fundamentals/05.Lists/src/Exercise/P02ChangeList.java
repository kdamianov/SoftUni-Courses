package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            List <String> commandLine = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            String commandName = commandLine.get(0);
            int element = Integer.parseInt(commandLine.get(1));

            if (commandName.equals("Delete")){
                numbers.removeAll(Arrays.asList(element));
                //asList прави лист от елементите с тази стойност, за да работи removeAll

            }else if (commandName.equals("Insert")) {
                int position = Integer.parseInt(commandLine.get(2));
                numbers.add(position, element);
            }
            command = scanner.nextLine();
        }
        for (Integer element : numbers) {
            System.out.print(element + " ");
        }
    }
}
