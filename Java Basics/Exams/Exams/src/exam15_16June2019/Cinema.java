package exam15_16June2019;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int sumPeople = 0;
        int totalPrice = 0;
        int profit = 0;
        boolean noSeats = false;

        String command = scanner.nextLine();

        while (!command.equals("Movie time!")) {
            int numPeople = Integer.parseInt(command);

            if (capacity < numPeople) {
                noSeats = true;
                break;
            }
            capacity = capacity - numPeople;

            sumPeople += numPeople;


            totalPrice = numPeople * 5;


            if (numPeople % 3 ==0) {
                totalPrice = totalPrice - 5;
            }
            profit = profit + totalPrice;


            command = scanner.nextLine();

        }
        if (noSeats) {
            System.out.printf("The cinema is full.%n");
        } else {
            System.out.printf("There are %d seats left in the cinema.%n", capacity);
        }
        System.out.printf("Cinema income - %d lv.", profit);
    }
}
