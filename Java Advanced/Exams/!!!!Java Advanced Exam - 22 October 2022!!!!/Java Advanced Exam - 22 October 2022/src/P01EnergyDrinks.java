import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

// Judge: 100/100

public class P01EnergyDrinks {
    static int maxCaffeine = 300;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentCaffeine
                = 0;

        ArrayDeque<Integer> milligramsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(milligramsStack::push);

        ArrayDeque<Integer> drinksQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(drinksQueue::offer);

        while (!milligramsStack.isEmpty() && !drinksQueue.isEmpty()) {
            int currentMilligrams = milligramsStack.peek();
            int currentDrink = drinksQueue.peek();

            int drinkCaffeine = currentMilligrams * currentDrink;

            milligramsStack.pop();
            drinksQueue.poll();

            if (currentCaffeine + drinkCaffeine <= maxCaffeine) {
                currentCaffeine += drinkCaffeine;
            } else {
                drinksQueue.offer(currentDrink);
                if (currentCaffeine >= 30) {
                    currentCaffeine -= 30;
                }
            }
        }
        if (!drinksQueue.isEmpty()) {
            System.out.printf("Drinks left: %s%n", drinksQueue.toString().replaceAll("\\[", "").replaceAll("]", ""));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n", currentCaffeine);
    }
}
