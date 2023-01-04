package moreExercise;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double moneySpent = 0;
        boolean zeroLeft = false;
        double price = 0;

        while (!command.equals("Game Time")) {

            switch (command) {
                case "OutFall 4":
                    price = 39.99;
                    if (price > balance) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    moneySpent += price;
                    balance -= price;
                    System.out.printf("Bought %s%n", command);
                    break;
                case "CS: OG":
                    price = 15.99;
                    if (price > balance) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    moneySpent += price;
                    balance -= price;
                    System.out.printf("Bought %s%n", command);
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    if (price > balance) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    moneySpent += price;
                    balance -= price;
                    System.out.printf("Bought %s%n", command);
                    break;
                case "Honored 2":
                    price = 59.99;
                    if (price > balance) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    moneySpent += price;
                    balance -= price;
                    System.out.printf("Bought %s%n", command);
                    break;
                case "RoverWatch":
                    price = 29.99;
                    if (price > balance) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    moneySpent += price;
                    balance -= price;
                    System.out.printf("Bought %s%n", command);
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    if (price > balance) {
                        System.out.println("Too Expensive");
                        break;
                    }
                    moneySpent += price;
                    balance -= price;
                    System.out.printf("Bought %s%n", command);
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            if (balance <= 0) {
                zeroLeft = true;
                break;
            }

            command = scanner.nextLine();
        }
        if (zeroLeft) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, balance);
        }

    }
}
