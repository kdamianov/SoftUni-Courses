package moreExercise;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        double microbus = 0;
        double truck = 0;
        double train = 0;

        for (int i = 1; i <= n ; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());

            if (cargoWeight <=3) {
                microbus += cargoWeight;

            } else if (cargoWeight <= 11) {
                truck += cargoWeight;
            } else {
                train += cargoWeight;
            }

        }
        double ttlCargo = microbus + truck + train;
        double averagePrice = (microbus * 200 + truck * 175 + train * 120) / ttlCargo;
        double microbusAverage = (microbus / ttlCargo) * 100;
        double truckAverage = (truck / ttlCargo) * 100;
        double trainAverage = (train / ttlCargo) * 100;

        System.out.printf("%.2f%n", averagePrice);
        System.out.printf("%.2f%%%n", microbusAverage);
        System.out.printf("%.2f%%%n", truckAverage);
        System.out.printf("%.2f%%%n", trainAverage);
    }
}
