package exam28And29March2020;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double trunkCapacity = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int suitcaseCount = 0;
        double trunkCapLeft = trunkCapacity;
        boolean isFull = false;

        while(!input.equals("End")) {
            double suitcaseVol = Double.parseDouble(input);

            suitcaseCount++;
            if (suitcaseCount % 3 == 0) {
                suitcaseVol = suitcaseVol * 1.10;
            }
            if (trunkCapLeft < suitcaseVol) {
                isFull = true;
                suitcaseCount--;
                break;
            }

            trunkCapLeft = trunkCapLeft - suitcaseVol;


            input = scanner.nextLine();
        }
        if (isFull) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", suitcaseCount);
    }
}
