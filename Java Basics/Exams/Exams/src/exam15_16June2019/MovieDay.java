package exam15_16June2019;

import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Време за снимки – цяло число в диапазона [0… 1440]
        int timeNeeded = Integer.parseInt(scanner.nextLine());
        //2.	Брой сцени  – цяло число в диапазона [5… 25]
        int scenesNum = Integer.parseInt(scanner.nextLine());
        //3.	Времетраене на сцена – цяло число в диапазона [20… 90]
        double sceneDuration = Double.parseDouble(scanner.nextLine());

        double prep = timeNeeded * 0.15;
        double ttlTime = scenesNum * sceneDuration + prep;

        if (timeNeeded >= ttlTime) {
            System.out.printf("You managed to finish the movie on time! " +
                    "You have %.0f minutes left!", Math.abs(timeNeeded - ttlTime));
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", Math.abs(timeNeeded - ttlTime));
        }
    }
}
