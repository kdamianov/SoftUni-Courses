package preExam9and10April2022;

import java.util.Scanner;

public class BraceletStand_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pocketMoneyPerDay = Double.parseDouble(scanner.nextLine());
        double profitPerDay = Double.parseDouble(scanner.nextLine());
        double expensesPerTotalPeriod = Double.parseDouble(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        int days = 5;

        double ttlPocketMoney = days * pocketMoneyPerDay;
        double ttlProfit = days * profitPerDay;
        double ttlMoney = ttlPocketMoney + ttlProfit;
        double netProfit = ttlMoney - expensesPerTotalPeriod;

        if (netProfit >= giftPrice) {
            System.out.printf("Profit: %.2f BGN, the gift has been purchased.", netProfit);
        } else {
            System.out.printf("Insufficient money: %.2f BGN.", giftPrice - netProfit);
        }


    }
}
