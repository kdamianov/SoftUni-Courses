import java.util.*;
import java.util.stream.Collectors;

//Judge: 100/100

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.Steel
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(steelQueue::offer);
        //2.Carbon
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbonStack::push);

        int gladius = 0;  // 70
        int shamshir = 0; // 80
        int katana = 0;   // 90
        int sabre = 0;    // 110
        Map<String, Integer> swords = new HashMap<>();

        while(!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int currentSteel = steelQueue.poll();
            int currentCarb = carbonStack.pop();

            if (currentSteel + currentCarb == 70) {
                gladius ++;
                swords.put("Gladius", gladius);
            } else if (currentSteel + currentCarb == 80) {
                shamshir ++;
                swords.put("Shamshir", shamshir);
            } else if (currentSteel + currentCarb == 90) {
                katana ++;
                swords.put("Katana", katana);
            } else if (currentSteel + currentCarb == 110) {
                sabre ++;
                swords.put("Sabre", sabre);
            } else {
                carbonStack.push(currentCarb + 5);
            }
        }
        int totalSwords = gladius + shamshir + katana + sabre;

        if (totalSwords != 0) {
            System.out.printf("You have forged %d swords.%n", totalSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String leftSteel = steelQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("Steel left: %s%n", leftSteel);
        }
        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            List<String> collect = carbonStack.stream().map(String::valueOf).collect(Collectors.toList());

            System.out.printf("Carbon left: %s%n", String.join(", ", collect));
        }
        swords.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
