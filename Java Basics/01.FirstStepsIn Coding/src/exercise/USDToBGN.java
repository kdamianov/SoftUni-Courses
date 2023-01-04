package exercise;

import java.util.Scanner;

public class USDToBGN {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //четем дробно число от конзолата

        double usd = Double.parseDouble(scanner.nextLine());

        double bgn = usd * 1.79549;

        System.out.println(bgn);

    }
}
