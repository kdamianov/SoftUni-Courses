package exercise;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //daljina
        int length = Integer.parseInt(scanner.nextLine());
        //shirina
        int width = Integer.parseInt(scanner.nextLine());
        //visochina
        int height = Integer.parseInt(scanner.nextLine());
        //procent aksesoari
        double percent = Double.parseDouble(scanner.nextLine());

        int ltInCm = length * width * height;
        double litInDm = ltInCm * 0.001;

        double litresNeeded = litInDm - (litInDm * percent / 100);

        System.out.println(litresNeeded);




    }
}
