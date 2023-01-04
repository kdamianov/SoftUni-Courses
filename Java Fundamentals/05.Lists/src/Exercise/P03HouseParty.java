package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandNum = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        while (commandNum > 0) {
            String commandLine = scanner.nextLine();
            String name = commandLine.split(" ")[0];

            if (commandLine.contains("is going")) {
                if (list.contains(name)) {
                    System.out.println(name + " is already in the list!");
                }else {
                    list.add(name);
                }
            } else if ((commandLine.contains("is not going"))) {
                if (list.contains(name)) {
                    list.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            }

            commandNum --;
        }
        for (String names : list) {
            System.out.println(names);
        }
    }
}

