package exercise.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String commandName = command[0];
            String vehicleType = command[1];
            double argument = Double.parseDouble(command[2]);

            switch (commandName) {
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    vehicleMap.get(vehicleType).refuel(argument);
                    break;
            }

        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption);
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption);
            default:
                throw new IllegalArgumentException("Missing car!");
        }
    }
}
