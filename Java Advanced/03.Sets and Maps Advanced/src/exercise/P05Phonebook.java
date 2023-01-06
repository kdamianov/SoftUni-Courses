package exercise;

import java.util.HashMap;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        HashMap<String, String> phoneBook = new HashMap<>();

        while(!input.equals("search")) {
            String[] personInfo = input.split("-");
            String name = personInfo[0];
            String number = personInfo[1];

            phoneBook.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if (phoneBook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phoneBook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
