package exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine()
                .split("\\s+")).collect(Collectors.toList());

        Set<String> filters= new HashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("Print")) {
            String[] commandParts = command.split(";");
            String addOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];

            if (addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            }else {
                filters.remove(type + ";" + parameter);
            }

            command = scanner.nextLine();
        }


    }
}
