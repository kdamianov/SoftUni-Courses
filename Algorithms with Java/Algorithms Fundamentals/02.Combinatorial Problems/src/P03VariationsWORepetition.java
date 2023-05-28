import java.util.HashSet;
import java.util.Scanner;

public class P03VariationsWORepetition {
    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        variations = new String[k];
        used = new boolean[elements.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index == variations.length) { //дъното на РЕКУРСИЯТА
            print(variations);
            return;
        }

        for (int i = 0; i < elements.length; i++) { //трябва да минем през абсолютно всички елементи
            if (!used[i]) {
                used[i] = true;
                variations[index] = elements[i]; //добавяме в новия масив

                variations(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
