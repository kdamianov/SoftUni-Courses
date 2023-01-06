import java.util.*;

//Judge 100/100

public class P01Bombs {
    static Map<String, Integer> bombPouch = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(bombEffectQueue::offer);

        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).forEach(bombCasingStack::push);

        //•	Datura Bombs: 40
        //•	Cherry Bombs: 60
        //•	Smoke Decoy Bombs: 120
        int datura = 0;
        int cherry = 0;
        int smokeDecoy = 0;
        boolean isFull = false;


        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            int bombEffect = bombEffectQueue.peek();
            int bombCasing = bombCasingStack.peek();

            int bomb = bombEffect + bombCasing;

            if (bomb == 40) {
                datura++;
                removeMaterials(bombEffectQueue, bombCasingStack);
                addBomb("Datura Bombs", datura);
            } else if (bomb == 60) {
                cherry++;
                removeMaterials(bombEffectQueue, bombCasingStack);
                addBomb("Cherry Bombs", cherry);
            } else if (bomb == 120) {
                smokeDecoy++;
                removeMaterials(bombEffectQueue, bombCasingStack);
                addBomb("Smoke Decoy Bombs", smokeDecoy);
            } else {
                bombCasingStack.pop();
                bombCasingStack.push(bombCasing - 5);
            }
            if (datura>=3 && cherry >= 3 && smokeDecoy >=3) {
                isFull = true;
                break;
            }

        }
        if (!isFull) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        } else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        if (bombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            String effects = bombEffectQueue.toString().replaceAll("\\[", "").replaceAll("]", "");
            System.out.printf("Bomb Effects: %s%n", effects);
        }
        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            String casing = bombCasingStack.toString().replaceAll("\\[", "").replaceAll("]", "");
            System.out.printf("Bomb Casings: %s%n",casing);

        }
        System.out.printf("Cherry Bombs: %d%n" +
                "Datura Bombs: %d%n" +
                "Smoke Decoy Bombs: %d%n", cherry, datura, smokeDecoy);
    }


    private static void addBomb(String s, int b) {
        bombPouch.put(s, b);
    }
    private static void removeMaterials(ArrayDeque<Integer> bombEffectQueue, ArrayDeque<Integer> bombCasingStack) {
        bombEffectQueue.poll();
        bombCasingStack.pop();
    }

}

