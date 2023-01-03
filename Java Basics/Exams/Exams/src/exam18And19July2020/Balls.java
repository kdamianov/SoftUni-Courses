package exam18And19July2020;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double points = 0;
        int redCount = 0;
        int orangeCount = 0;
        int yellowCount = 0;
        int whiteCount = 0;
        int blackCount = 0;
        int other = 0;

        for (int i = 1; i <= n; i++) {
            String color = scanner.nextLine();

            if (color.equals("red")) {
                points = points + 5;
                redCount++;
            } else if(color.equals("orange")) {
                points = points + 10;
                orangeCount++;
            }else if (color.equals("yellow")) {
                points = points + 15;
                yellowCount++;
            }else if (color.equals("white")) {
                points = points + 20;
                whiteCount++;
            }else if (color.equals("black")) {
                points = Math.floor(points / 2);
                blackCount++;
            }else {
                other++;
            }
        }
        System.out.printf("Total points: %.0f%n" +
                "Red balls: %d%n" +
                "Orange balls: %d%n" +
                "Yellow balls: %d%n" +
                "White balls: %d%n" +
                "Other colors picked: %d%n" +
                "Divides from black balls: %d",
                points, redCount, orangeCount, yellowCount, whiteCount, other, blackCount);

    }
}
