package moreExercise;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        String ticket = scanner.nextLine();
        int numberOfFans = Integer.parseInt(scanner.nextLine());


        if (numberOfFans >= 1 && numberOfFans <= 4) {
            budget -= budget * 0.75;
        } else if (numberOfFans <= 9) {
            budget -= budget * 0.60;
        } else if (numberOfFans <= 24) {
            budget -= budget * 0.50;
        } else if (numberOfFans <= 49) {
            budget -= budget * 0.40;
        } else {
            budget -= budget * 0.25;
        }

        double ticketsPrice = 0;

        if (ticket.equals("VIP")) {
            ticketsPrice = numberOfFans * 499.99;
        } else {
            ticketsPrice = numberOfFans * 249.99;
        }

        double diff = Math.abs(ticketsPrice - budget);

        if (budget >= ticketsPrice) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }


    }
}

