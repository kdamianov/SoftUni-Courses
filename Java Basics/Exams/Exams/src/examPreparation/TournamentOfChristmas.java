package examPreparation;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double ttlDaysSum = 0;
        int countTtlDaysWin = 0;
        int countTtlDaysLoss = 0;

        for (int i = 1; i <= days; i++) {
            double dayProfit = 0;

            int dayCountWin = 0;
            int dayCountLoss = 0;

            String input = scanner.nextLine();
            while (!input.equals("Finish")) {
                String status = scanner.nextLine();

                if (status.equals("win")) {
                    dayProfit = dayProfit + 20;
                    dayCountWin++;
                } else if (status.equals("lose")) {
                    dayCountLoss++;
                }



                input = scanner.nextLine();
            }
            countTtlDaysWin = countTtlDaysWin + dayCountWin;
            countTtlDaysLoss = countTtlDaysLoss + dayCountLoss;

            if (dayCountWin > dayCountLoss) {
                dayProfit = dayProfit * 1.10;
            }

            ttlDaysSum = ttlDaysSum + dayProfit;


        }

        if (countTtlDaysWin > countTtlDaysLoss) {
            ttlDaysSum = ttlDaysSum * 1.20;
            System.out.print("You won the tournament! ");
        } else {
            System.out.print("You lost the tournament! ");
        }
        System.out.printf("Total raised money: %.2f", ttlDaysSum);
    }
}
