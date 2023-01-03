package exam28And29March2020;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gruops = Integer.parseInt(scanner.nextLine());
        double musala = 0;
        double monblan = 0;
        double kilim = 0;
        double k2 = 0;
        double everest = 0;
        int ttlPeople = 0;

        for (int i = 1; i <= gruops; i++) {
            int numPeople = Integer.parseInt(scanner.nextLine());
            ttlPeople += numPeople;

            if (numPeople <= 5) {
                musala += numPeople;
            } else if (numPeople <=12){
                monblan += numPeople;
            } else if (numPeople <= 25) {
                kilim += numPeople;
            } else if (numPeople <= 40) {
                k2 +=numPeople;
            } else {
                everest += numPeople;
            }


        }
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", musala / ttlPeople * 100,
                monblan / ttlPeople * 100, kilim / ttlPeople * 100,
                k2 / ttlPeople * 100, everest / ttlPeople * 100);
    }
}
