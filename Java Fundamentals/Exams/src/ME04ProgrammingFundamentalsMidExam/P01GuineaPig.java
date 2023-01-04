package ME04ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	On the first line – quantity food in kilograms - a floating-point number in the range [0.0 – 10000.0]
        double foodInKg = Double.parseDouble(scanner.nextLine());
        //•	On the second line – quantity hay in kilograms - a floating-point number in the range [0.0 – 10000.0]
        double hayInKg = Double.parseDouble(scanner.nextLine());
        //•	On the third line – quantity cover in kilograms - a floating-point number in the range [0.0 – 10000.0]
        double coverInKg = Double.parseDouble(scanner.nextLine());
        //•	On the fourth line – guinea's weight in kilograms - a floating-point number in the range [0.0 – 10000.0]
        double pigWeightInKg = Double.parseDouble(scanner.nextLine());
        int days = 30;
        double foodLeft = foodInKg;
        double hayLeft = hayInKg;
        double coverLeft = coverInKg;
        boolean isFinished = false;

        for (int day = 1; day <= 30; day++) {
            foodLeft -= 0.300;

            if (day % 2 == 0) {
                hayLeft -= foodLeft * 0.05;
            }
            if (day % 3 == 0) {
                coverLeft -= pigWeightInKg/3;
            }
            if (foodLeft <=0 || hayLeft <= 0 || coverLeft <= 0 ) {
                isFinished = true;
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }
        if (!isFinished) {
            System.out.printf("Everything is fine! Puppy is happy! " +
                    "Food: %.2f, Hay: %.2f, Cover: %.2f.", foodLeft, hayLeft, coverLeft);
        }
    }
}
