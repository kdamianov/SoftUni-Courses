package ME03ProgrammingFundamentalsMidExamRetake;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initEnergy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int winCount = 0;
        boolean notEnough = false;

        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);
            if (initEnergy < distance) {
                notEnough = true;
                System.out.printf("Not enough energy! " +
                        "Game ends with %d won battles and %d energy", winCount, initEnergy);
                break;
            }

            initEnergy -= distance;
            winCount ++;

            if (winCount % 3 == 0) {
                initEnergy += winCount;
            }




            command = scanner.nextLine();
        }
        if (!notEnough) {
            System.out.printf("Won battles: %d. Energy left: %d ", winCount, initEnergy);
        }
    }
}
