import java.util.Arrays;
import java.util.Scanner;

public class P01PermutationsWORepetition {
    public static String[] elements;
    public static String[] permutes; //пазим данните тук
    public static boolean[] used; //пазим използваните елементи тук
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        permutes = new String[elements.length];
        used = new boolean[elements.length];

        permute(0);
    }
    private static void permute(int index) {
        if (index == elements.length) { //дъното на РЕКУРСИЯТА
            print();
            return;
        }
        //permute(index);
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true; //запазваме го като използван елемент, за да няма повторение
                permutes[index] = elements[i]; //пълним новия масив с дадения елемент
                permute(index + 1); //предизвикваме стъпка в Рекурсията
                used[i] = false; //освобождаваме го --> backtracking
            }
        }
    }
    private static void print() {
        System.out.println(String.join(" ", permutes));
    }

//--- ОПТИМИЗРАН КОД ЧРЕЗ SWAP АЛГОРИТЪМ!!! ---
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        elements = scanner.nextLine().split("\\s+");
//        permute(0);
//    }
//    private static void permute(int index) {
//        if (index == elements.length) { //дъното на РЕКУРСИЯТА
//            print(elements);
//            return;
//        }
//        permute(index + 1);
//        for (int i = index + 1; i < elements.length; i++) {
//            swap(elements, index, i);
//            permute(index + 1); //предизвикваме стъпка в Рекурсията
//            swap(elements, index, i);
//        }
//    }
//    private static void print(String[] arr) {
//        System.out.println(String.join(" ", arr));
//    }
//    private static void swap(String[] arr, int first, int second){
//        String temp = arr[first];
//        arr[first] = arr[second];
//        arr[second] = temp;
//    }
}
