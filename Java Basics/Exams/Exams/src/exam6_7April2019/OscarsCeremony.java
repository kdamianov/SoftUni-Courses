package exam6_7April2019;

import java.util.Scanner;

public class OscarsCeremony {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());

        double statues = rent * 0.70;
        double catering = statues * 0.85;
        double sound = catering / 2;

        double ttl = rent * 1.0 + statues + catering + sound;

        System.out.printf("%.2f", ttl);

    }
}
