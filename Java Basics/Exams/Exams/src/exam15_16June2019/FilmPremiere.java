package exam15_16June2019;

import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String moviePack = scanner.nextLine();
        int numTickets = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (movie) {
            case "John Wick":
                if (moviePack.equals("Drink")) {
                    price = numTickets * 12;
                } else if (moviePack.equals("Popcorn")) {
                    price = numTickets * 15;
                } else {
                    price = numTickets * 19;
                }
                break;
            case "Star Wars":
                if (moviePack.equals("Drink")) {
                  price =  numTickets * 18;
                } else if (moviePack.equals("Popcorn")) {
                    price = numTickets * 25;
                } else {
                    price = numTickets * 30;
                }
                break;
            case "Jumanji":
                if (moviePack.equals("Drink")) {
                price = numTickets * 9;
                } else if (moviePack.equals("Popcorn")) {
                    price = numTickets * 11;
                } else {
                    price = numTickets * 14;
                }
                break;

        }
        if (movie.equals("Star Wars") && numTickets >= 4) {
            price -= price * 0.30;
        } else if (movie.equals("Jumanji") && numTickets == 2) {
            price -= price * 0.15;
        }

        System.out.printf("Your bill is %.2f leva.", price);

    }
}
