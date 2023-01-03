package preExam9and10April2022;

import java.util.Scanner;

public class Workout_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDays = Integer.parseInt(scanner.nextLine());
        double firstKm = Double.parseDouble(scanner.nextLine());

        double km = firstKm;
        double totalKm = km;


        for (int i = 1; i <= numDays; i++) {
            double k = Double.parseDouble(scanner.nextLine());
            km = km + (km * k /100);
            totalKm += km;

        }
        if (totalKm >= 1000) {
            System.out.printf("You've done a great job running" +
                    " %.0f more kilometers!", Math.ceil(totalKm - 1000));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000 - totalKm));
        }

    }
}
