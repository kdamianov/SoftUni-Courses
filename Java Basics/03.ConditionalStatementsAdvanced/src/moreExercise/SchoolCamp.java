package moreExercise;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Сезонът – текст - “Winter”, “Spring” или “Summer”;
        String season = scanner.nextLine();
        //2.	Видът на групата – текст - “boys”, “girls” или “mixed”;
        String group = scanner.nextLine();
        //3.	Брой на учениците – цяло число в интервала [1 … 10000];
        int numStudents = Integer.parseInt(scanner.nextLine());
        //4.	Брой на нощувките – цяло число в интервала [1 … 100].
        int numNights = Integer.parseInt(scanner.nextLine());

        double nightPrice = 0;
        String sport = "";


        switch (season) {
            case "Winter":
                if (group.equals("girls")) {
                    nightPrice = 9.60;
                    sport = "Gymnastics";
                } else if (group.equals("boys")) {
                    nightPrice = 9.60;
                    sport = "Judo";
                } else {
                    nightPrice = 10;
                    sport = "Ski";
                }
                break;
            case "Spring":
                if (group.equals("girls")) {
                    nightPrice = 7.20;
                    sport = "Athletics";
                } else if (group.equals("boys")) {
                    nightPrice = 7.20;
                    sport = "Tennis";
                } else {
                    nightPrice = 9.50;
                    sport = "Cycling";
                }
                break;
            case "Summer":
                if (group.equals("girls")) {
                    nightPrice = 15;
                    sport = "Volleyball";
                } else if (group.equals("boys")) {
                    nightPrice = 15;
                    sport = "Football";
                } else {
                    nightPrice = 20;
                    sport = "Swimming";
                }
                break;
        }
        double ttl = numStudents * nightPrice * numNights;
        if (numStudents >= 10 && numStudents < 20) {
            ttl = ttl * 0.95;
        } else if (numStudents >= 20 && numStudents < 50) {
            ttl = ttl * 0.85;
        } else if (numStudents >= 50) {
            ttl = ttl * 0.50;
        }
        System.out.printf("%s %.2f lv.", sport, ttl);
    }
}
