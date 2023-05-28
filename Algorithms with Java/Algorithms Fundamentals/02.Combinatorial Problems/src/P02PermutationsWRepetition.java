import java.util.HashSet;
import java.util.Scanner;

public class P02PermutationsWRepetition {
    public static String[] elements;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        permute(0);
    }
    private static void permute(int index) {
        if (index == elements.length) { //дъното на РЕКУРСИЯТА
            print(elements);
            return;
        }
        permute(index + 1);
        HashSet<String> swapped = new HashSet<>(); //пазим използваният елемент тук, за да няма повторения
        swapped.add(elements[index]);

        for (int i = index + 1; i < elements.length; i++) {
            if (!swapped.contains(elements[i])) {
                swap(elements, index, i);
                permute(index + 1); //предизвикваме стъпка в Рекурсията
                swap(elements, index, i);
                swapped.add(elements[i]); //ъпдейтваме състоянието на елемента
            }
        }
    }
    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
    private static void swap(String[] arr, int first, int second){
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
