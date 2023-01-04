package ME03ProgrammingFundamentalsMidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("End")) {
            int targetIndex = Integer.parseInt(input);
            if (targetIndex > targets.length -1) { //if targetIndex is out of range
                input = scanner.nextLine();
                continue;
            }

            for (int i = 0; i < targets.length; i++) {
                int temp = targets[targetIndex];
                //Reduce all the other targets, which have greater values than your current target, with its value.
                if (targets[i] > temp && i != targetIndex && targets[i] != -1) {
                    targets[i] -= temp;
                }else if (targets[i] <= temp && i != targetIndex && targets[i] != -1) {
                    targets[i] += temp;
                //Increase all the other targets, which have less than or equal value to the shot target, with its value.
                }
            }
            targets[targetIndex] = -1;
            count ++; //counts successfull targets



            input = scanner.nextLine();
        }
        System.out.print("Shot targets: " + count + " -> ");
        for (int i = 0; i < targets.length; i++) {
            System.out.print(targets[i] + " ");
        }
    }
}
