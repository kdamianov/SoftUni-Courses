package exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


//ДА Я ВИДЯ В ЛЕКЦИЯТА!!!!


public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 !=0) { //1то е четно, 2то не е четно
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            //и
            return first.compareTo(second);
        };
        Arrays.sort(numbers, comparator);

        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
