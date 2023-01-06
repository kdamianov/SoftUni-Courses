package p01KAT;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] firstInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToLong(Long::parseLong).toArray();
        long[] secondInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToLong(Long::parseLong).toArray();

        ArrayDeque<Long> carPlatesQueue = new ArrayDeque<>();
        ArrayDeque<Long> carsStack = new ArrayDeque<>();

        for (long carPlate : firstInput) {
            carPlatesQueue.offer(carPlate);
        }
        for (long car : secondInput) {
            carsStack.push(car);
        }

        long countRegisteredCars = 0;
        int daysNeeded = 0;


        while (!carsStack.isEmpty() && !carPlatesQueue.isEmpty()) {
            daysNeeded++;
            long currentCars = carsStack.pop();
            long currentPlates = carPlatesQueue.poll();

            //cars > plates / 2
            //cars < plates / 2
            //cars == plates / 2
            if (currentCars > currentPlates / 2) {
                long restCars = currentCars - currentPlates / 2;
                //добавяме остатък в началото
                carsStack.addLast(restCars);
                countRegisteredCars += currentPlates / 2;
            } else if (currentCars < currentPlates / 2) {
                long restPlates = currentPlates - currentCars * 2;
                //добаваме остатък в края
                carPlatesQueue.addLast(restPlates);
                countRegisteredCars += currentCars;
            } else {
                countRegisteredCars += currentCars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", countRegisteredCars, daysNeeded);
        if (carsStack.isEmpty() && !carPlatesQueue.isEmpty()) {
            long remainingPlates = 0;
            for (Long plate : carPlatesQueue) {
                remainingPlates += carPlatesQueue.poll();
            }
            System.out.printf("%d license plates remain!%n", remainingPlates);
        } else if (!carsStack.isEmpty() && carPlatesQueue.isEmpty()) {
            long remainingCars = 0;
            for (Long car : carsStack) {
                remainingCars += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!%n", remainingCars);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
