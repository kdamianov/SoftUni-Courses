package exam6_7April2019;

import java.util.Scanner;

public class OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        String hallType = scanner.nextLine();
        int ticketsBought = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (movieName) {
            case "A Star Is Born":
                if (hallType.equals("normal")) {
                    price = 7.50;
                } else if (hallType.equals("luxury")){
                    price = 10.50;
                } else if (hallType.equals("ultra luxury")) {
                    price = 13.50;
                }
                break;
            case "Bohemian Rhapsody":
                if (hallType.equals("normal")) {
                    price = 7.35;
                } else if (hallType.equals("luxury")){
                    price = 9.45;
                } else if (hallType.equals("ultra luxury")) {
                    price = 12.75;
                }
                break;
            case "Green Book":
                if (hallType.equals("normal")) {
                    price = 8.15;
                } else if (hallType.equals("luxury")){
                    price = 10.25;
                } else if (hallType.equals("ultra luxury")) {
                    price = 13.25;
                }
                break;
            case "The Favourite":
                if (hallType.equals("normal")) {
                    price = 8.75;
                } else if (hallType.equals("luxury")){
                    price = 11.55;
                } else if (hallType.equals("ultra luxury")) {
                    price = 13.95;
                }
                break;
        }
        System.out.printf("%s -> %.2f lv.", movieName, ticketsBought * price);
    }
}
