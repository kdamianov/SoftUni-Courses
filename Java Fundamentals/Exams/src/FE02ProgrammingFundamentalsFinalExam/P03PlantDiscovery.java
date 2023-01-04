package FE02ProgrammingFundamentalsFinalExam;

import java.util.*;
//100/100 в JUDGE!!!

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> plantsDataMap = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatingsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] plantsInfo = scanner.nextLine().split("<->");
            //"[0]{plant}<->[1]{rarity}"
            String plant = plantsInfo[0];
            String rarity = plantsInfo[1];
            if (!plantsDataMap.containsKey(plant)) {
                plantsDataMap.put(plant, rarity);
            } else {
                String oldRarity = plantsDataMap.get(plant);
                plantsDataMap.replace(plant,oldRarity, rarity);
            }
            plantsRatingsMap.put(plant, new ArrayList<>());
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            if (command.contains("Rate:")) {
                //•	"Rate: {plant} - {rating}"
                String plant = command.split(" ")[1];
                Double rating = Double.valueOf(command.split(" - ")[1]);
                if (plantsDataMap.containsKey(plant)) {
                    plantsRatingsMap.get(plant).add(rating);
                } else {
                    System.out.println("error");
                }
            } else if (command.contains("Update:")) {
                //•	"Update: {plant} - {new_rarity}"
                String plant = command.split(" ")[1];
                String newRarity = command.split(" - ")[1];
                if (plantsDataMap.containsKey(plant)) {
                    plantsDataMap.put(plant, newRarity);
                } else {
                    System.out.println("error");
                }
            } else if (command.contains("Reset:")) {
                //•	"Reset: {plant}"
                String plant = command.split(" ")[1];
                if (plantsDataMap.containsKey(plant)) {
                    plantsRatingsMap.get(plant).clear();
                } else {
                    System.out.println("error");
                }
            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantsDataMap.entrySet().stream().forEach(e -> System.out.printf("- %s; Rarity: %s; Rating: %.2f%n", e.getKey(), e.getValue(),
                plantsRatingsMap.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }
}
