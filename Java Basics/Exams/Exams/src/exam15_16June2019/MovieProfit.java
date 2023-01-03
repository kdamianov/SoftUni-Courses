package exam15_16June2019;

import java.util.Scanner;

public class MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Име на филм - текст
        String movieName = scanner.nextLine();
        //2.	Брой дни - цяло число в диапазона [1… 90]
        int days = Integer.parseInt(scanner.nextLine());
        //3.	Брой билети  - цяло число в диапазона [100… 100000]
        int tickets = Integer.parseInt(scanner.nextLine());
        //4.	Цена на билет - реално число в диапазона [5.0… 25.0]
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        //5.	Процент за киното - цяло число в диапазона [5... 35]
        int percent = Integer.parseInt(scanner.nextLine());

        double profit = days * tickets * ticketPrice;
        double finalProfit = profit - (profit * percent) / 100;

        System.out.printf("The profit from the movie %s is %.2f lv.", movieName, finalProfit);
    }
}
