package MoreEx;

import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        if (findDistance(x1, y1) <= findDistance(x2, y2)) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }


    }

    private static double findDistance (int x, int y) {
        double newX = x * 1.0;
        double newY = y * 1.0;

        return Math.sqrt(Math.abs((Math.pow(newX, 2)) + (Math.pow(newY, 2))));
    }
}
