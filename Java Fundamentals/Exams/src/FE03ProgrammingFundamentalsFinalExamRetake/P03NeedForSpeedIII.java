package FE03ProgrammingFundamentalsFinalExamRetake;

import java.util.*;
//100/100 в JUDGE !!!

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            //"{car}|{mileage}|{fuel}"
            String[] carInput = scanner.nextLine().split("\\|");
            String carModel = carInput[0];
            int mileage = Integer.parseInt(carInput[1]);
            int fuel = Integer.parseInt(carInput[2]);

            carMap.put(carModel, new ArrayList<>());
            carMap.get(carModel).add(mileage);
            carMap.get(carModel).add(fuel);
        }
        String commandInput = scanner.nextLine();


        while (!commandInput.equals("Stop" )) {
            String[] commandInfo = commandInput.split(" : ");
            String command = commandInfo[0];
            String car = commandInfo[1];
            int currentFuel = carMap.get(car).get(1);
            int currentMilleage = carMap.get(car).get(0);

            switch (command) {
                case "Drive":
                //•	"Drive : {car} : {distance} : {fuel}":
                    int distance = Integer.parseInt(commandInfo[2]);
                    int fuelNeeded = Integer.parseInt(commandInfo[3]);

                    if (fuelNeeded > currentFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        currentMilleage += distance;
                        carMap.get(car).set(0, currentMilleage);
                        currentFuel -= fuelNeeded;
                        carMap.get(car).set(1, currentFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                car, distance, fuelNeeded);
                        if (currentMilleage >= 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            carMap.remove(car);
                        }
                    }
                    break;
                case "Refuel":
                //•	"Refuel : {car} : {fuel}":
                    int fuelToFill = Integer.parseInt(commandInfo[2]);
                    currentFuel += fuelToFill;
                    if (currentFuel >= 75) {
                        fuelToFill -= currentFuel -75;
                        currentFuel = 75;
                    }
                    carMap.get(car).set(1, currentFuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuelToFill);
                    break;
                case "Revert":
                //•	"Revert : {car} : {kilometers}":
                    int kmToRevert = Integer.parseInt(commandInfo[2]);
                    int newCurrentMilleage = currentMilleage - kmToRevert;
                    if (newCurrentMilleage < 10000) {
                        carMap.get(car).set(0, 10000);
                    } else {
                        carMap.get(car).set(0, newCurrentMilleage);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kmToRevert);
                    }

                    break;
            }
            commandInput = scanner.nextLine();
        }
        carMap.entrySet().forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
