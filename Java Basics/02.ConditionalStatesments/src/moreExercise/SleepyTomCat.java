import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());
        int workingDays = 365 - holidays;

        int playTimeHolidays = holidays * 127;
        int playTimeWork = workingDays * 63;
        int playTimePerYear = playTimeHolidays + playTimeWork;

        double diff = Math.abs(30000 - playTimePerYear);

        if (playTimePerYear > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%.0f hours and %.0f minutes more for play",
                    Math.floor(diff / 60), Math.floor(diff % 60));

        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%.0f hours and %.0f minutes less for play",
                    Math.floor(diff / 60), Math.floor(diff %60));
        }
    }
}
