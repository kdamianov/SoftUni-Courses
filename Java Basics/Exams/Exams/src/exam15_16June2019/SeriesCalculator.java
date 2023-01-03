package exam15_16June2019;

import java.util.Scanner;

public class SeriesCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());

        double ttlLength = length * 1.2;
        int addMin = seasons * 10;

        double ttlTime = seasons * episodes * ttlLength + addMin;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.",
                movieName, Math.floor(ttlTime));


    }
}
