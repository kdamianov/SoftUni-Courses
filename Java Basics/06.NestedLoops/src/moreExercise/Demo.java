package moreExercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstGame = scanner.nextLine();
        String secondGame = scanner.nextLine();
        String thirdGame = scanner.nextLine();


        int won = 0;
        int lost = 0;
        int draw = 0;

        char goalsScored1 = firstGame.charAt(0);
        char goalsScored2 = secondGame.charAt(0);
        char goalsScored3 = thirdGame.charAt(0);
        char goalsReceived1 = firstGame.charAt(2);
        char goalsReceived2 = secondGame.charAt(2);
        char goalsReceived3 = thirdGame.charAt(2);



        if (goalsScored1 > goalsReceived1) {
            won++;
        } else if (goalsScored1 < goalsReceived1) {
            lost++;
        } else {
            draw++;
        }
        if (goalsScored2 > goalsReceived2) {
            won++;
        } else if (goalsScored2 < goalsReceived2) {
            lost++;
        } else {
            draw++;
        }
        if (goalsScored3 > goalsReceived3) {
            won++;
        } else if (goalsScored3 < goalsReceived3) {
            lost++;
        } else {
            draw++;
        }

        System.out.printf("Team won %d games.%n" +
                "Team lost %d games.%n" +
                "Drawn games: %d", won, lost, draw);
    }
}
