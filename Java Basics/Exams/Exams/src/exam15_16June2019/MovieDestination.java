package exam15_16June2019;

import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        int filmDayPrice = 0;

        switch (destination) {
            case "Dubai":
                if (season.equals("Winter")) {
                    filmDayPrice = 45000;
                } else {
                    filmDayPrice = 40000;
                }
                break;
            case "Sofia":
                if (season.equals("Winter")) {
                    filmDayPrice = 17000;
                } else {
                    filmDayPrice = 12500;
                }
                break;
            case "London":
                if (season.equals("Winter")) {
                    filmDayPrice = 24000;
                } else {
                    filmDayPrice = 20250;
                }
                break;

        }
        double budgetNeeded = days * filmDayPrice;

        if (destination.equals("Dubai")) {
            budgetNeeded -= budgetNeeded * 0.30;
        } else if (destination.equals("Sofia")) {
            budgetNeeded += budgetNeeded * 0.25;
        }
        if (movieBudget >= budgetNeeded) {
            System.out.printf("The budget for the movie is enough! " +
                    "We have %.2f leva left!", Math.abs(budgetNeeded - movieBudget));
        } else {
            System.out.printf("The director needs %.2f leva more!", Math.abs(movieBudget - budgetNeeded));
        }

    }
}
