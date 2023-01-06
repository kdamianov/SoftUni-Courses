package P05CarSalesmanExercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        //read engines\zxdz
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);

            Engine engine = null;
            //създаваме обект, според броя полета във входните данни
            if (input.length == 2) {
                engine = new Engine(model, power);
            } else if (input.length == 3) {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine (model, power, displacement);
                } catch (NumberFormatException exception){
                    String efficiency = input[2];
                    engine = new Engine (model, power, efficiency);

                }
            } else {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);

            }
            engines.put(model, engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        //read cars
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            //създаваме нова инстанция с референция от вече съществуващ обект(Engine)!!!!
            Engine carEngine = engines.get(engineModel);
            Car car = null;
            if (input.length == 2) {
                car = new Car(model, carEngine);
            } else if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new Car(model, carEngine, weight, color);
            } else {
                try {
                    int weight = Integer.parseInt(input[2]);
                    car = new Car(model, carEngine, weight);
                } catch (NumberFormatException e) {
                    String color = input[2];
                    car = new Car(model, carEngine, color);
                }
            }
            carList.add(car);
        }

        carList.forEach(System.out::println);
    }
}
