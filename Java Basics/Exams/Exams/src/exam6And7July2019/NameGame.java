package exam6And7July2019;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int points = 0;
        int pointsFirst = 0;
        int pointsSecond = 0;
        int pointsThird = 0;
        int player = 0;
        String firstPlayer = " ";
        String secondPlayer = " ";
        String thirdPrayer = " ";

        while (!input.equals("Stop")) {
            String playerName = input;
            int name = input.length();
            player++;
            if (player ==1) {
                firstPlayer = playerName;
            } else if (player == 2){
                secondPlayer = playerName;
            } else {
                thirdPrayer = playerName;
            }
            for (int i = 0; i <= name -1; i++) {
                int number = Integer.parseInt(scanner.nextLine());

                if (number == input.charAt(i)) {
                    points = points + 10;
                } else {
                    points = points + 2;
                }

            }
            if (player == 1) {
                pointsFirst = points;
            } else if (player == 2){
                pointsSecond = points - pointsFirst;
            } else {
                pointsThird = points - (pointsFirst+pointsSecond);
            }

            input = scanner.nextLine();
        }
        if (pointsFirst > pointsSecond) {
            System.out.printf("The winner is %s with %s points!", firstPlayer, pointsFirst);
        } else if ( pointsFirst < pointsSecond) {
            System.out.printf("The winner is %s with %s points!", secondPlayer, pointsSecond);
        } else {
            System.out.printf("The winner is %s with %s points!", secondPlayer, pointsSecond);
        }

    }
}
