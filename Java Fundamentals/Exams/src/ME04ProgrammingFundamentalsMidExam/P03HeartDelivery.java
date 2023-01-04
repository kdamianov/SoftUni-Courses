package ME04ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> houses = Arrays.stream(scanner.nextLine().split("@")).
                map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        int currentIndex = 0;

        while (!input.equals("Love!")) {
            String[] commandLine = input.split(" ");
            int jumpLength = Integer.parseInt(commandLine[1]);

            currentIndex += jumpLength;

            if (currentIndex >= houses.size()) {
                currentIndex = 0;
            }

            if (houses.get(currentIndex) != 0) {
                int newHouseValue = houses.get(currentIndex) - 2;
                houses.set(currentIndex, newHouseValue);
                if (houses.get(currentIndex) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }

            } else {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        boolean isSuccessful = true;
        for (int i = 0; i < houses.size(); i++){
            if (houses.get(i) != 0) {
                isSuccessful = false;
                break;
            }
        }
        int housesCount = 0;
        for (int i = 0; i <= houses.size() - 1; i++) {
            if (houses.get(i) > 0 ) {
                housesCount ++;
            }
        }
        if (housesCount > 0) {
            System.out.printf("Cupid has failed %d places.%n", housesCount);
        } else if (housesCount == 0) {
            System.out.println("Mission was successful.");
        }
    }
}
