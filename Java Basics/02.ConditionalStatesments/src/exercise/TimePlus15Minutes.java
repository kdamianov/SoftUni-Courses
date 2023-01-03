package exercise;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int ttlMin = hour * 60 + min + 15;

        hour = ttlMin / 60; // намираме час
        min = ttlMin % 60; // намираме минутите

        if (hour > 23) {
            hour = 0;
        }
        if (min < 10) {
            System.out.printf("%d:0%d", hour, min);
        } else {
            System.out.printf("%d:%d", hour, min);
        }
    }
}
