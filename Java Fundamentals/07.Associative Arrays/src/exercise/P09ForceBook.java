package exercise;

import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> forceUsers = new LinkedHashMap<>();

        while (!input.contains("Lumpawaroo")) {
            if (input.contains("|")) {
                String force = input.split(" \\| ")[0];
                String user = input.split(" \\| ")[1];

                List<String> players = new ArrayList<>();
                //ако няма такъв отбор
                if (!forceUsers.containsKey(force)) {
                    forceUsers.put(force, players);
                }
                //играча го има в някой отбор
                boolean isExist = false;
                for (List<String> list : forceUsers.values()) {
                    if (list.contains(user)) {
                        isExist = true;
                    }
                }
                if (!isExist) {
                    forceUsers.get(force).add(user);
                }

            } else if (input.contains("->")) {
                String user = input.split(" -> ")[0];
                String force = input.split(" -> ")[1];

                //ако играчът съшествува, го махаме от текущия му отбор

                forceUsers.forEach((key, value) -> value.remove(user));
                //добавяме го към новия отбор, ако съществува
                if (forceUsers.containsKey(force)) {
                    List<String> currentTeam = forceUsers.get(force);
                    currentTeam.add(user);
                //ако не съществува обтор и играч, ги създаваме
                } else {
                    forceUsers.put(force, new ArrayList<>());
                    forceUsers.get(force).add(user);
                }
                System.out.printf("%s joins the %s side!%n", user, force);

            }

            input = scanner.nextLine();
        }
        forceUsers.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                //оставяме само тези записи, които отговарят на условието
                .forEach(entry -> {
                //Side: , Members:
                            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().forEach(player -> System.out.println("! " + player));
                        }
                );
    }
}