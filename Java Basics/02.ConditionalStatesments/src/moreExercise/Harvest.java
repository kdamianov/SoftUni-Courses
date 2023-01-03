import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vineyardSize = Integer.parseInt(scanner.nextLine());
        double grapesPerSqM = Double.parseDouble(scanner.nextLine());
        int wineNeeded = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double grapesHarvestKg;
        grapesHarvestKg = grapesPerSqM * vineyardSize * 0.40;
        double wineProduction = grapesHarvestKg / 2.5;
        double diff = Math.abs(wineNeeded - wineProduction);

        if (wineProduction < wineNeeded) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",
                    Math.floor(diff));
        } else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",
                    Math.floor(wineProduction));
            double wineForWorkers = diff / workers;

            System.out.printf("%.0f liters left -> %.0f liters per person.",
                    Math.ceil(diff), Math.ceil(wineForWorkers));
        }
    }
}
