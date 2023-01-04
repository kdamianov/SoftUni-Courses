package midExamPrep;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        double totalSumWOTax = 0;
        while (!inputLine.equals("special") && !inputLine.equals("regular")) {
            double currentAmount = Double.parseDouble(inputLine);
            if (currentAmount < 0) {
                System.out.println("Invalid price!");
                inputLine = scanner.nextLine();
                continue;
            }

            totalSumWOTax += currentAmount;


            inputLine = scanner.nextLine();
        }
        if (totalSumWOTax == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalSumWOTax);
            double taxes = totalSumWOTax * 0.20;
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            double sumWithTaxes = totalSumWOTax + taxes;
            if (inputLine.equals("special")) {
                sumWithTaxes = sumWithTaxes * 0.90;
            }
            System.out.printf("Total price: %.2f$%n", sumWithTaxes);
        }
    }

}
