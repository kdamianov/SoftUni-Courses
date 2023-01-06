package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
//  ДА СЕ ПРОВЕРИ ДАЛИ РАБОТИ!!!!
public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //       user                  ip        count
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputParts = input.split(" ");
            String ipAddress = inputParts[0].substring(3);
            String userName = inputParts[2].substring(5);

            if (!users.containsKey(userName)) {
                users.put(userName, new LinkedHashMap<>());
            }
            if (!users.get(userName).containsKey(ipAddress)) {
                users.get(userName).put(ipAddress, 1);
            } else {
                int currentCount = users.get(userName).get(ipAddress) + 1;
                users.get(userName).put(ipAddress, currentCount);
            }
            input = scanner.nextLine();
        }
        for (var attacker : users.entrySet()) {
            System.out.printf("%s:%n", attacker.getKey());
            LinkedHashMap<String, Integer> attacks = attacker.getValue();
            StringBuilder sb = new StringBuilder();
            for (var ipAttack : attacks.entrySet()) {
                sb.append(String.format("%s => %d,\n", ipAttack.getKey(), ipAttack.getValue()));
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            System.out.println(finalOutput + ".");
        }
    }
}
