package ME06ProgrammingFundamentalsMidExamRetake;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //the days of the plunder – an integer number in the range [0…100000]
        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        //the daily plunder – an integer number in the range [0…50]
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        //the expected plunder – a real number in the range [0.0…10000.0]
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double totalPlunder = 0;

        for (int days = 1; days <= daysOfPlunder; days++) {
            totalPlunder += dailyPlunder;

            if (days % 3 == 0) {
                totalPlunder += dailyPlunder * 0.50;
            }
            if (days % 5 == 0) {
                totalPlunder = totalPlunder - (totalPlunder * 0.30);
            }




        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.%n", totalPlunder/expectedPlunder * 100);
        }
    }
}
