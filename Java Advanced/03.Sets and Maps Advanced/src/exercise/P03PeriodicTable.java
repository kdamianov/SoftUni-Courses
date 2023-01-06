package exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < number; i++) {
            String[] compounds = scanner.nextLine().split(" ");
            //for (String element : compounds) {
            //    elements.add(element);
            //}
            Collections.addAll(elements, compounds);

        }

        String result = String.join(" ", elements);
        //Може и да се обходи Сет и да се принтира
        // elements.stream().forEach(e -> System.out.print(e + " "));
        System.out.println(result);
    }
}
