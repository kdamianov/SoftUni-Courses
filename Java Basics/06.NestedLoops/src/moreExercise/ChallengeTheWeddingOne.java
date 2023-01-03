package moreExercise;

import java.util.Scanner;

public class ChallengeTheWeddingOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numMen = Integer.parseInt(scanner.nextLine());
        int numWomen = Integer.parseInt(scanner.nextLine());
        int maxNumTable = Integer.parseInt(scanner.nextLine());

        int countTables = 0;

            for (int i = 1; i <= numMen; i++) {
                for (int j = 1; j <= numWomen; j++) {
                    countTables++;
                    if (countTables > maxNumTable){
                        break;
                    } else {
                        System.out.printf("(%d <-> %d) ",i, j);
                    }
                }
            }
    }
}
