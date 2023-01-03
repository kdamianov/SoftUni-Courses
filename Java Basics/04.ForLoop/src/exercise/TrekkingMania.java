package exercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int musalla = 0;
        int montBlanc = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;
        int ttlPeople = 0;


        for (int i = 1; i <= n; i++) {

            int people = Integer.parseInt(scanner.nextLine());

            if (people <=5) {
                musalla = musalla + people;

            } else if (people <=12) {
                montBlanc = montBlanc + people;
            } else if (people <=25) {
                kilimanjaro = kilimanjaro +people;
            } else if (people <=40) {
                k2 = k2 + people;
            } else {
                everest = everest + people;
            }

            ttlPeople += people;
        }
        System.out.printf("%.2f%%%n", musalla * 1.0 / ttlPeople * 100);
        System.out.printf("%.2f%%%n", montBlanc * 1.0 / ttlPeople * 100);
        System.out.printf("%.2f%%%n", kilimanjaro * 1.0 / ttlPeople * 100);
        System.out.printf("%.2f%%%n", k2 * 1.0 / ttlPeople * 100);
        System.out.printf("%.2f%%%n", everest * 1.0 / ttlPeople * 100);
    }
}
