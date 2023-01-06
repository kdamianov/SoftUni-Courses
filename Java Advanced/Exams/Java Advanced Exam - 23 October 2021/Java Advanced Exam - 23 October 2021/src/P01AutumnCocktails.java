import java.util.*;

//Judge 100/100


public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(ingredientsQueue::offer);

        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(freshnessLevelStack::push);

        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;
        Map<String, Integer> cocktails = new TreeMap<>();

        while (!ingredientsQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {
            int ingredient = ingredientsQueue.peek();
            int freshness = freshnessLevelStack.peek();
            if (ingredient == 0) {
                ingredientsQueue.poll();
                continue;
            }
            int product = ingredient * freshness;
            if (product == 150) {
                pearSour++;
                cocktails.put("Pear Sour", pearSour);
                removeIngredients(ingredientsQueue, freshnessLevelStack);
            }else if (product == 250) {
                theHarvest++;
                cocktails.put("The Harvest", theHarvest);
                removeIngredients(ingredientsQueue, freshnessLevelStack);
            }else if (product == 300) {
                appleHinny++;
                cocktails.put("Apple Hinny", appleHinny);
                removeIngredients(ingredientsQueue, freshnessLevelStack);
            }else if (product == 400) {
                highFashion++;
                cocktails.put("High Fashion", highFashion);
                removeIngredients(ingredientsQueue, freshnessLevelStack);
            }else {
                removeIngredients(ingredientsQueue, freshnessLevelStack);
                ingredientsQueue.offer(ingredient + 5);
            }
        }
        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sumIngredients = 0;
        for (Integer ingredient : ingredientsQueue) {
            sumIngredients += ingredient;
        }
        if (sumIngredients > 0) {
            System.out.printf("Ingredients left: %d%n", sumIngredients);
        }

        cocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));

    }

    private static void removeIngredients (ArrayDeque<Integer> ingredientsQueue, ArrayDeque<Integer> freshnessLevelStack) {
        ingredientsQueue.poll();
        freshnessLevelStack.pop();
    }
}
