package exam6And7July2019;

import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double profitWanted = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();
        double profit = 0;
        boolean isAcqired = false;

        while (!input.equals("Party!")) {
            String cocktaiilName = input;
            int numCocktails = Integer.parseInt(scanner.nextLine());
            int price = cocktaiilName.length();
            double ttlPrice = numCocktails * price;
            if (ttlPrice % 2 != 0) {
                ttlPrice = ttlPrice * 0.75;
            }
            profit += ttlPrice;

            if (profit >= profitWanted) {
                isAcqired = true;
                break;
            }


            input = scanner.nextLine();
        }

        if (isAcqired) {
            System.out.println("Target acquired.");
        } else {
            System.out.printf("We need %.2f leva more.%n",
                    profitWanted - profit);
        }
        System.out.printf("Club income - %.2f leva.", profit);



    }
}
