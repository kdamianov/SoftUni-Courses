package moreExercise;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //числа x1, y1, x2, y2, x и y
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
//•	x съвпада с x1 или x2 и същевременно y е между y1 и y2
//•	y съвпада с y1 или y2 и същевременно x е между x1 и x2
        if ((x == x1 || x==x2) && (y >=y1 && y <= y2)) {
            System.out.println("Border");
        } else if ((y == y1 || y == y2) && (x >=x1 && x <=x2)) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
