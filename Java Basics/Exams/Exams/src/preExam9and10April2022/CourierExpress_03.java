package preExam9and10April2022;

import java.util.Scanner;

public class CourierExpress_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double packWeightInKg = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        double distanceInKm = Double.parseDouble(scanner.nextLine());
        double extraPricePerDistance = 0;
        double extraPricePerKilo = 0;
        double totalPrice = 0;

        if (type.equals("standard")) {
            if (packWeightInKg < 1) {
                totalPrice = distanceInKm * 0.03;
            } else if (packWeightInKg < 10) {
                totalPrice = distanceInKm * 0.05;
            } else if (packWeightInKg < 40) {
                totalPrice = distanceInKm * 0.10;
            } else if (packWeightInKg < 90) {
                totalPrice = distanceInKm * 0.15;
            } else if (packWeightInKg < 150) {
                totalPrice = distanceInKm * 0.20;
            }
        } else {
            //•	За пратки по - леки от 1 кг – на килограм по 80 % от съответната цена на километър
            //•	От 1 кг до 10  кг – на килограм по 40 % от съответната цена на километър
            //•	От 10 кг вкл. до 40 кг – на килограм по 5 % от съответната цена на километър
            //•	От 40 кг вкл. до 90  кг – на килограм по 2 % от съответната цена на километър
            //•	От 90 кг вкл. до 150 кг – на килограм по 1 % от съответната цена на километър
            if (packWeightInKg < 1) {
                totalPrice = distanceInKm * 0.05;
                extraPricePerKilo = 0.05 * 0.80;
                extraPricePerDistance = (extraPricePerKilo * packWeightInKg) * distanceInKm;
                totalPrice = totalPrice + extraPricePerDistance;
            } else if (packWeightInKg < 10) {
                totalPrice = distanceInKm * 0.03;
                extraPricePerKilo = 0.05 * 0.40;
                extraPricePerDistance = (extraPricePerKilo * packWeightInKg) * distanceInKm;
                totalPrice = totalPrice + extraPricePerDistance;
            } else if (packWeightInKg < 40) {
                totalPrice = distanceInKm * 0.10;
                extraPricePerKilo = 0.10 * 0.05;
                extraPricePerDistance = (extraPricePerKilo * packWeightInKg) * distanceInKm;
                totalPrice = totalPrice + extraPricePerDistance;
            } else if (packWeightInKg < 90) {
                totalPrice = distanceInKm * 0.15;
                extraPricePerDistance = (0.15 * 0.02 * packWeightInKg) * distanceInKm;
                totalPrice = totalPrice + extraPricePerDistance;
            } else if (packWeightInKg < 150) {
                totalPrice = distanceInKm * 0.20;
                extraPricePerDistance = (0.20 * 0.01 * packWeightInKg) * distanceInKm;
                totalPrice = totalPrice + extraPricePerDistance;
            }
        }
        System.out.printf("The delivery of your shipment with " +
                "weight of %.3f kg. would cost %.2f lv.", packWeightInKg, totalPrice);
    }
}
