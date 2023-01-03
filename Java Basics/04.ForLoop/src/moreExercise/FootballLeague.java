package moreExercise;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int fansA = 0;
        int fansB = 0;
        int fansV = 0;
        int fansG = 0;

        for (int i = 1; i <=n ; i++) {
            String sector = scanner.nextLine();

            if (sector.equals("A")) {
                fansA ++;
            } else if (sector.equals("B")) {
                fansB ++;
            } else if (sector.equals("V")) {
                fansV ++;
            } else {
                fansG ++;
            }

        }
        System.out.printf("%.2f%%%n", fansA * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", fansB * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", fansV * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", fansG * 1.0 / n * 100);
        System.out.printf("%.2f%%", n * 1.0 / capacity *100);

    }
}
