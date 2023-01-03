package moreExercise;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int rowsFirstSector = Integer.parseInt(scanner.nextLine());
        int numSeatsOddRow = Integer.parseInt(scanner.nextLine());

        int numSeatsEvenRow = numSeatsOddRow + 2;
        int numSeats = 0;
        int countSeats = 0;

        for (int sector = 65; sector <= lastSector; sector++) {
            if (sector > 65) {
                rowsFirstSector++;
            }
            for (int rows = 1; rows <= rowsFirstSector; rows++) {
                if (rows % 2 == 0) {
                    numSeats = numSeatsEvenRow;
                } else {
                    numSeats = numSeatsOddRow;
                }
                for (int seats = 1; seats <= numSeats; seats++) {
                    char numSeats1 = (char) (seats + 96);
                    countSeats++;
                    System.out.printf("%C%d%c%n", sector, rows, numSeats1);

                }

            }

        }
        System.out.println(countSeats);

    }
}
