package exam28And29March2020;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
        double record = Double.parseDouble(scanner.nextLine());
        //2.	Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
        double distance = Double.parseDouble(scanner.nextLine());
        //3.	Времето в секунди, за което изкачва 1 м. – реално число в интервала [0.00 … 1000.00]
        double timePerMeterInSec = Double.parseDouble(scanner.nextLine());

        double slowDistance = Math.floor(distance / 50);
        double addTime = slowDistance * 30;
        double ttlTime = distance * timePerMeterInSec + addTime;

        if (ttlTime >= record) {
            System.out.printf("No! He was %.2f seconds slower.", ttlTime - record);
        } else {
            System.out.printf("Yes! The new record is %.2f seconds.", ttlTime);
        }

    }
}
