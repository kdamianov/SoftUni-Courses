package exam15_16June2019;

import java.util.Scanner;

public class MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        String actorName = scanner.nextLine();
        double salary = 0;
        boolean notEnough = false;

        while (!actorName.equals("ACTION")) {
            int actorNameLength = actorName.length();

            if (actorNameLength > 15) {
                salary = budget * 0.20;
            } else {
                salary = Double.parseDouble(scanner.nextLine());
            }

            if (salary > budget) {
                notEnough = true;
                break;
            }
            budget = budget - salary;

            actorName = scanner.nextLine();

        }
        if (notEnough) {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget - salary));
        } else {
            System.out.printf("We are left with %.2f leva.", budget);
        }
    }
}
