package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String commandInput = scanner.nextLine();

        while (!commandInput.equals("end")) {

            String[] commandLine = commandInput.split(" ");
            if (commandLine[0].equals("Add")) {
                int newPassengers = Integer.parseInt(commandLine[1]);
                wagons.add(newPassengers);
            } else {
                int newPassengers = Integer.parseInt(commandLine[0]);
                for (int index = 0; index < wagons.size(); index++) {
                    if (wagons.get(index) + newPassengers <= maxCapacity) {
                        wagons.set(index, wagons.get(index) + newPassengers);
                        break;
                    }
                }
            }
            commandInput = scanner.nextLine();
        }
        for (int wagon: wagons) {
            System.out.print(wagon + " ");
        }
    }
}
