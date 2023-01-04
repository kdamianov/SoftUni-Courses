package ME01ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentWagon = 0;

        for (int i = 0; i < lift.length; i++) {
            if (lift[i] < 4) {
                if (people >= 4 - lift[i]) {
                    people -= 4 - lift[i];
                    lift[i] = 4;
                } else {
                    lift[i] += people;
                    people = 0;
                }
                currentWagon = lift[i];

            }

            }
        if (people == 0 && lift[lift.length - 1] < 4) {
            System.out.println("The lift has empty spots!");
            for (int j = 0; j < lift.length; j++) {

            }
        }
    }
}
