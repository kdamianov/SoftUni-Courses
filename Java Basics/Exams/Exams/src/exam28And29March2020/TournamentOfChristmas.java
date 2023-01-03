package exam28And29March2020;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDays = Integer.parseInt(scanner.nextLine());

        int ttlWin = 0;
        int ttlLoss = 0;
        double ttlProfit = 0;

        for (int i = 1; i <= numDays; i++) {
            int winCount = 0;
            int lossCount = 0;
            double moneyWon = 0;

            String input = scanner.nextLine();
            while (!input.equals("Finish")) {
                String result = scanner.nextLine();

                if (result.equals("win")) {
                    winCount++;
                    ttlWin++;
                    moneyWon = moneyWon + 20;
                } else {
                    lossCount++;
                    ttlLoss++;
                }

                input = scanner.nextLine();
            }
            if (winCount > lossCount) {
                moneyWon = moneyWon * 1.10;
            }
            ttlProfit = ttlProfit + moneyWon;
        }
        if (ttlWin > ttlLoss) {
            ttlProfit = ttlProfit * 1.20;
        }
        if (ttlWin > ttlLoss) {
            System.out.printf("You won the tournament! Total raised money: %.2f", ttlProfit);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", ttlProfit);
        }
    }

}
