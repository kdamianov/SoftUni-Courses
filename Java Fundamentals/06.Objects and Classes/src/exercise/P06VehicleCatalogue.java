package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06VehicleCatalogue {
    static class Vehicle {
        //полета -> характеристики
        private String type;
        private String model;
        private String color;
        private int horsePower;

        //конструктор
        public Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        //методи -> функционалности
        public String getType() {
            return type;
        }
        public String getModel() {
            return model;
        }
        public String getColor() {
            return color;
        }
        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            //Type: {typeOfVehicle}
            //Model: {modelOfVehicle}
            //Color: {colorOfVehicle}
            //Horsepower: {horsepowerOfVehicle}
            String formattedType = "";
            if (this.type.equals("car")) {
                formattedType = "Car";
            } else if (this.type.equals("truck")) {
                formattedType = "Truck";
            }
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                    formattedType, this.model, this.color, this.horsePower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputData = input.split(" ");
            String type = inputData[0];
            String model = inputData[1];
            String color = inputData[2];
            int horsePower = Integer.parseInt(inputData[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            vehicleList.add(vehicle);

            input = scanner.nextLine();
        }

        String inputModel = scanner.nextLine();

        while (!inputModel.equals("Close the Catalogue")) {

            for (Vehicle vehicle: vehicleList) {
                if (inputModel.equals(vehicle.getModel())) {
                    System.out.println(vehicle);
                    break;
                }
            }

            inputModel = scanner.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", getAverageHP(vehicleList, "cars"));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", getAverageHP(vehicleList, "trucks"));
    }

    private static Double getAverageHP(List<Vehicle> vehicleList, String type) {
        double sum = 0;
        int count = 0;

        if (type.equals("cars")) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getType().equals("car")) {
                    sum += vehicle.getHorsePower();
                    count ++;
                }
            }
        } else if (type.equals("trucks")) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getType().equals("truck")) {
                    sum += vehicle.getHorsePower();
                    count ++;
                }
            }
        }
        if (sum == 0) {
            return 0.00;
        }
        return sum / count;
    }

    }