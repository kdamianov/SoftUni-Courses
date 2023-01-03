package exam18And19July2020;

import java.util.Scanner;

public class AgencyProfit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int childrenTickets = Integer.parseInt(scanner.nextLine());
        double netPriceAdult = Double.parseDouble(scanner.nextLine());
        double serviceTax = Double.parseDouble(scanner.nextLine());

        double netPriceChildren = netPriceAdult * 0.30;

        double finalAdult = (netPriceAdult + serviceTax) * adultTickets;
        double finalChildren = (netPriceChildren + serviceTax) * childrenTickets;

        double profit = (finalAdult + finalChildren) * 20 / 100;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",
                name, profit);

    }
}
