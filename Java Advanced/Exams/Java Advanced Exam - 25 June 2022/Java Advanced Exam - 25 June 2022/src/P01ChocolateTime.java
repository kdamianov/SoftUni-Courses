import java.util.*;


//Judge: 100/100


public class P01ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] milkValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        double[] cacaoValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        fillMilk(milkValues, milkQueue);
        fillCacao(cacaoValues, cacaoStack);

        Map<String, Integer> chocolates = new TreeMap<>();
        int milkChocolate = 0;
        int darkChocolate = 0;
        int bakingChocolate = 0;

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double milk = milkQueue.poll();
            double cacao = cacaoStack.pop();

            double chocolate = cacao / (milk + cacao) * 100;
            if (chocolate == 30) {
                milkChocolate ++;
                chocolates.put("Milk Chocolate",milkChocolate);
            }else if (chocolate == 50) {
                darkChocolate ++;
                chocolates.put("Dark Chocolate",darkChocolate);
            }else if (chocolate == 100) {
                bakingChocolate ++;
                chocolates.put("Baking Chocolate",bakingChocolate);
            } else {
                double newMilkValue = milk + 10;
                milkQueue.offer(newMilkValue);
            }
        }

        if (hasAllChocolates(milkChocolate, darkChocolate, bakingChocolate)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.entrySet().forEach(e -> System.out.printf("# %s --> %d%n", e.getKey(), e.getValue()));
    }

    private static boolean hasAllChocolates(int milkChocolate, int darkChocolate, int bakingChocolate) {
        if (milkChocolate > 0 && darkChocolate > 0 && bakingChocolate > 0) {
            return true;
        }
        return false;
    }

    private static void fillCacao(double[] cacaoValues, ArrayDeque<Double> cacaoStack) {
        for (double cacao : cacaoValues) {
            cacaoStack.push(cacao);
        }
    }

    private static void fillMilk(double[] milkValues, ArrayDeque<Double> milkQueue) {
        for (double milk : milkValues) {
            milkQueue.offer(milk);
        }
    }
}
