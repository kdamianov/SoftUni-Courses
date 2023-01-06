import java.util.*;

//Judge 100/100

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach((ingredientsStack::push));

        //Biscuit	25
        //Cake	    50
        //Pastry	75
        //Pie	    100
        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();

            int sum = liquid + ingredient;

            liquidsQueue.poll();
            ingredientsStack.pop();
            if (sum == 25) {
                biscuit++;
            }else if (sum == 50) {
                cake++;
            }else if (sum == 75) {
                pastry++;
            }else if (sum == 100) {
                pie++;
            }else {
                ingredientsStack.push(ingredient + 3);
            }
        }
        if (biscuit > 0 && cake > 0 && pastry > 0 && pie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        }else {
            System.out.print("Liquids left: ");
            System.out.println(liquidsQueue.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        }else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }
        System.out.printf("Biscuit: %d%n" +
                "Cake: %d%n" +
                "Pie: %d%n" +
                "Pastry: %d%n", biscuit, cake, pie, pastry);
    }
}
