package finalExamPrep02;

import java.util.*;

public class P03eedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carsToken = scanner.nextLine().split("\\|");
            String car = carsToken[0];
            int mileage = Integer.parseInt(carsToken[1]);
            int fuel = Integer.parseInt(carsToken[2]);

            carsMap.putIfAbsent(car, new ArrayList<>());
            carsMap.get(car).add(0, mileage);
            carsMap.get(car).add(1, fuel);

        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Stop")) {
            String[] tokens = inputLine.split(" : ");
            String command = tokens[0];
            String car = tokens[1];
            int mileage = carsMap.get(car).get(0);
            int fuel = carsMap.get(car).get(1);

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int consumedFuel = Integer.parseInt(tokens[3]);

                    if (fuel >= consumedFuel) {
                        carsMap.get(car).set(0, mileage + distance);
                        carsMap.get(car).set(1, fuel - consumedFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, consumedFuel);

                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (mileage >= 100000) {
                        System.out.printf("Time to sell the %s!%n", car);
                        carsMap.remove(car);
                    }
                    break;
                case "Refuel":
                    int refillFuel = Integer.parseInt(tokens[2]);
                    int totalFuel = fuel + refillFuel;
                    int fuelDiff = 0;

                    if (totalFuel > 75) {
                        fuelDiff = 75 - fuel;
                        totalFuel = 75;
                    } else {
                        fuelDiff = refillFuel;
                    }
                    carsMap.get(car).set(1, totalFuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuelDiff);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(tokens[2]);
                    int totalMileage = mileage - kilometers;

                    if (totalMileage < 10000) {
                        totalMileage = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }

                    carsMap.get(car).set(0, totalMileage);
                    break;

            }

            inputLine = scanner.nextLine();
        }
        carsMap.forEach((key, value) ->
                System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key, value.get(0), value.get(1)));
    }
}
