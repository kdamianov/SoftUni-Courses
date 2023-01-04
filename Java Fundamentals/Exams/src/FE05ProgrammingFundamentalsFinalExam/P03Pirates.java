package FE05ProgrammingFundamentalsFinalExam;

import java.util.*;
//100/100 в JUDGE!!!

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        Map<String, List<Integer>> citiesInfo = new LinkedHashMap<>();

        while(!firstInput.equals("Sail")){
        //city - Tortuga||[0]population - 345000||[1]goldInCity - 1250

            String[] cityInfo = firstInput.split("\\|\\|");
            String city = cityInfo[0];
            int population = Integer.parseInt(cityInfo[1]);
            int goldInCity = Integer.parseInt(cityInfo[2]);
            if (!citiesInfo.containsKey(city)) {
                citiesInfo.put(city, new ArrayList<>());
                citiesInfo.get(city).add(population);
                citiesInfo.get(city).add(goldInCity);
            } else {
                int currentPopulation = citiesInfo.get(city).get(0);
                int newPopulation = currentPopulation + population;
                int currentGold = citiesInfo.get(city).get(1);
                int newGold = currentGold + goldInCity;
                citiesInfo.get(city).set(0, newPopulation);
                citiesInfo.get(city).set(1, newGold);
            }

            firstInput = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        while(!secondInput.equals("End")) {
            String[] commandLine = secondInput.split("=>");
            String command = commandLine[0];
            String town = commandLine[1];

            switch (command) {
                case "Plunder":
                //"Plunder=>{town}=>{people}=>{gold}"
                    int peopleKilled = Integer.parseInt(commandLine[2]);
                    int goldStolen = Integer.parseInt(commandLine[3]);
                    int peopleInCity = citiesInfo.get(town).get(0);
                    int goldInCIty = citiesInfo.get(town).get(1);
                    citiesInfo.get(town).set(0, peopleInCity - peopleKilled);
                    citiesInfo.get(town).set(1, goldInCIty - goldStolen);
                    int newPopulation = citiesInfo.get(town).get(0);
                    int newGold = citiesInfo.get(town).get(1);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town,
                                goldStolen, peopleKilled);

                    if (newPopulation == 0 || newGold == 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        citiesInfo.remove(town);
                    }
                    break;
                case "Prosper":
                //"Prosper=>{town}=>{gold}"
                    int addedGold = Integer.parseInt(commandLine[2]);
                    if (addedGold >= 0) {
                        int currentGold = citiesInfo.get(town).get(1);
                        int totalGold = currentGold + addedGold;
                        citiesInfo.get(town).set(1, totalGold);
                        System.out.printf("%d gold added to the city treasury. " +
                                "%s now has %d gold.%n", addedGold, town, totalGold);
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }

            secondInput = scanner.nextLine();
        }
        int count = 0;
        for (Map.Entry<String, List<Integer>> city : citiesInfo.entrySet()) {
            count ++;
        }

        if (citiesInfo.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", count);
            citiesInfo.entrySet().forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
        }
    }
}
