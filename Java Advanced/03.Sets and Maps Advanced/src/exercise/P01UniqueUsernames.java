package exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> namesSet = new LinkedHashSet<>();

        for (int i = 0; i < numberOfNames; i++) {
            String name = scanner.nextLine();
            namesSet.add(name);
        }

        for (String name : namesSet) {
            System.out.println(name);
        }

    }
}
