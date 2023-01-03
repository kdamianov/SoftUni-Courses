package moreExercise;

import java.util.Scanner;

public class Dishwasher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDetergent = Integer.parseInt(scanner.nextLine());
        int ttlDetergent = numDetergent * 750;
        int loadCount = 0;
        int detergentNeeded = 0;
        int countDishes = 0;
        int countPots = 0;
        String command = scanner.nextLine();
        boolean notEnough = false;


        while (!command.equals("End" )) {
            int numDishes = Integer.parseInt(command);


            loadCount++;

            if (loadCount % 3 == 0) {
                detergentNeeded = numDishes * 15;
                countPots = countPots + numDishes;
            } else {
                detergentNeeded = numDishes * 5;
                countDishes = countDishes + numDishes;
            }

            if (ttlDetergent < detergentNeeded) {
                notEnough = true;
                break;
            }

            ttlDetergent = ttlDetergent - detergentNeeded;




            command = scanner.nextLine();



        }
        if (notEnough) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", detergentNeeded - ttlDetergent);
        } else {
            System.out.printf("Detergent was enough!%n" +
                    "%d dishes and %d pots were washed.%n" +
                    "Leftover detergent %d ml.", countDishes, countPots, ttlDetergent);
        }
    }
}
