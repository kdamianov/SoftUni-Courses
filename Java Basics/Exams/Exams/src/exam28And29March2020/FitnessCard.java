package exam28And29March2020;

import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Сумата, с която разполагаме - реално число в интервала [10.00…1000.00]
        double ammount = Double.parseDouble(scanner.nextLine());
        //•	Пол - символ ('m' за мъж и 'f' за жена)
        char sex = scanner.nextLine().charAt(0);
        //•	Възраст - цяло число в интервала [5…105]
        int age = Integer.parseInt(scanner.nextLine());
        //•	Спорт - текст (една от възможностите в таблицата)
        String sport = scanner.nextLine();

        double price = 0;

        switch (sport) {
            case "Gym":
                if (sex == 109) {
                    price = 42;
                } else {
                    price = 35;
                }
                break;
            case "Boxing":
                if (sex == 109) {
                    price = 41;
                } else {
                    price = 37;
                }
                break;
            case "Yoga":
                if (sex == 109) {
                    price = 45;
                } else {
                    price = 42;
                }
                break;
            case "Zumba":
                if (sex == 109) {
                    price = 34;
                } else {
                    price = 31;
                }
                break;
            case "Dances":
                if (sex == 109) {
                    price = 51;
                } else {
                    price = 53;
                }
                break;
            case "Pilates":
                if (sex == 109) {
                    price = 39;
                } else {
                    price = 37;
                }
                break;
        }
        if (age <= 19) {
            price = price * 0.80;
        }
        if (ammount >= price) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", price - ammount);
        }

    }
}
