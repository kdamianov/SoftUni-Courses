package moreEx;

import java.util.Scanner;

public class P01xtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            //"Hello my name is @Peter| and I am #20* years old."

            int startNameIndex = text.indexOf("@");
            int endNameIndex = text.indexOf("|");
            String name = text.substring(startNameIndex + 1, endNameIndex);
            int startAgeIndex = text.indexOf("#");
            int endAgeIndex = text.indexOf("*");
            int age = Integer.parseInt(text.substring(startAgeIndex + 1, endAgeIndex));

            System.out.printf("%s is %d years old.%n", name, age);
        }
    }
}
