package exam6And7July2019;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String clubName = scanner.nextLine();
        int games = Integer.parseInt(scanner.nextLine());
        int w = 0;
        int d = 0;
        int l = 0;
        int points = 0;
        boolean noGames = false;


        for (int i = 1; i <= games; i++) {
            String result = scanner.nextLine();
            if (result.equals("W")) {
                w++;
                points = points + 3;
            } else if (result.equals("D")) {
                d++;
                points = points + 1;
            } else {
                l++;
            }

        }
        if (games == 0) {
            noGames = true;
        }

        if (noGames) {
            System.out.printf("%s hasn't played any games during this season.", clubName);
        } else {
            System.out.printf("%s has won %d points during this season.%n" +
                    "Total stats:%n" +
                    "## W: %d%n" +
                    "## D: %d%n" +
                    "## L: %d%n" +
                    "Win rate: %.2f%%%n", clubName, points, w, d, l, w * 1.0 / games * 100);
        }


    }
}
