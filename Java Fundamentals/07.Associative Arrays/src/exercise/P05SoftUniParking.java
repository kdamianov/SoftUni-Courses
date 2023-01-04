package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> userInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];
            String userName = input.split(" ")[1];


            switch (command) {
                case "register" :
                String plateNumber = input.split(" ")[2];
                if (!userInfo.containsKey(userName)) {
                    userInfo.put(userName, plateNumber);
                    System.out.printf("%s registered %s successfully%n", userName, plateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", userInfo.get(userName));
                }
                break;
                case "unregister":
                    if (userInfo.containsKey(userName)) {
                        userInfo.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", userName);
                    }
                break;
            }
        }
        userInfo.entrySet().forEach(entry -> System.out.printf("%s => %s%n", entry.getKey(), entry.getValue()));
    }
}
