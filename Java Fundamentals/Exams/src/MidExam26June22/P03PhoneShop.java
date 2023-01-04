package MidExam26June22;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phonesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] inputLine = input.split(" - ");
            String command = inputLine[0];
            String phone = inputLine[1];

            switch (command) {
                case "Add":
                    if (!phonesList.contains(phone)) {
                        phonesList.add(phone);
                    }
                    break;
                case "Remove":
                    if (phonesList.contains(phone)) {
                        phonesList.remove(phone);
                    }
                    break;
                case "Bonus phone":
                    String[] newPhoneList = phone.split(":");
                    String oldPhone = newPhoneList[0];
                    String newPhone = newPhoneList[1];

                    if (phonesList.contains(oldPhone)) {
                        phonesList.add(phonesList.indexOf(oldPhone) + 1, newPhone);                    }
                    break;
                case "Last":
                    if (phonesList.contains(phone)) {
                        phonesList.add(phone);
                        phonesList.remove(phonesList.indexOf(phone));


                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", phonesList));
    }
}
