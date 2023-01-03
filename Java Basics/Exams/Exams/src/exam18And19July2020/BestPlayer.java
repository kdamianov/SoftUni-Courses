package exam18And19July2020;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int moreGoals = 0;
        int hatTrick = 0;
        boolean tenGoals = false;
        String bestPlayer = " ";

        while (!name.equals("END")) {
            int goals = Integer.parseInt(scanner.nextLine());
            if (goals > moreGoals) {
                moreGoals = goals;
                bestPlayer = name;
            }
            if (moreGoals >= 3) {
                hatTrick = moreGoals;
            }
            if (moreGoals >= 10) {
                tenGoals = true;

                break;
            }

            name = scanner.nextLine();


        }
        if (tenGoals) {
            System.out.printf("%s is the best player!%n" +
                    "He has scored %d goals and made a hat-trick !!!", bestPlayer, moreGoals);
        }else {
            System.out.printf("%s is the best player!%n", bestPlayer);
            if (moreGoals >=3) {
                System.out.printf("He has scored %d goals and made a hat-trick !!!", moreGoals);
            } else {
                System.out.printf("He has scored %d goals.", moreGoals);
            }
        }
    }
}
