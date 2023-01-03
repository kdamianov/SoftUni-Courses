package exercise;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double clothsPerStatist = Double.parseDouble(scanner.nextLine());

        double decor = movieBudget * 0.10;
        double sumCloths = statists * clothsPerStatist;

        if (statists > 150) {
            sumCloths = sumCloths - 0.10 * sumCloths;
        }
        double ttlSum = decor + sumCloths;
        double moneyLeft = Math.abs(movieBudget - ttlSum);

        if (ttlSum > movieBudget) {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", moneyLeft);
        } else {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", moneyLeft);
        }
    }
}
