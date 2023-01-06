import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(secondBoxStack::push);

        int collection = 0;

        while(!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstValue = firstBoxQueue.peek();
            int secondValue = secondBoxStack.peek();

            secondBoxStack.pop();

            if ((firstValue + secondValue) % 2 == 0) {
                collection += firstValue + secondValue;
                firstBoxQueue.poll();

            }else {
                firstBoxQueue.offer(secondValue);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }

        if (collection >= 100) {
            System.out.printf("Your loot was epic! Value: %d", collection);
        }else {
            System.out.printf("Your loot was poor... Value: %d", collection);
        }

    }
}
