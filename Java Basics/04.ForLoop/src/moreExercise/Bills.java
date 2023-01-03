package moreExercise;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        double others = 0;
        double ttlElectricity = 0;

        for (int i = 1; i <= n; i++) {
            double electricity = Double.parseDouble(scanner.nextLine());

            ttlElectricity += electricity;
            others += (electricity + 20 + 15) * 1.2;
        }
        double water = n * 20;
        double net = n * 15;

        double avg = (ttlElectricity + water + net + others) / n;

        System.out.printf("Electricity: %.2f lv%n", ttlElectricity);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", net);
        System.out.printf("Other: %.2f lv%n", others);
        System.out.printf("Average: %.2f lv", avg);
    }
}
