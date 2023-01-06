package exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> partyList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String commandInput = scanner.nextLine();

        while(!commandInput.equals("Party!")) {
            String[] commandLine = commandInput.split("\\s+");
            String command = commandLine[0];
            String type = commandLine[1];
            String parameter = commandLine[2];

            if (command.equals("Remove")) {
                partyList.removeIf(getPredicate(type, parameter));
            } else if (command.equals("Double")) {
                for (int i = 0; i < partyList.size(); i++) {
                    String guest = partyList.get(i);
                    if (getPredicate(type, parameter).test(guest)) {
                        partyList.add(i++, guest);
                    }
                }
            }

            commandInput = scanner.nextLine();
        }
        Collections.sort(partyList);
        if (partyList.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", String.join(", ", partyList));
        }

    }
    public static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return  text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text -> false;
        }
    }
}
