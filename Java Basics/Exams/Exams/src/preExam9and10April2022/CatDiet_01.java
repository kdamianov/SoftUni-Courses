package preExam9and10April2022;

import java.util.Scanner;

public class CatDiet_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double fatPercent = Double.parseDouble(scanner.nextLine());
        double proteinPercent = Double.parseDouble(scanner.nextLine());
        double carbsPercent = Double.parseDouble(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        double waterPercent = Double.parseDouble(scanner.nextLine());

        double fatGrams = (totalCalories * fatPercent / 100) / 9;
        double proteinGrams = (totalCalories * proteinPercent / 100) / 4;
        double carbsGrams = (totalCalories * carbsPercent / 100) / 4;

        double totalGrams = fatGrams + proteinGrams + carbsGrams;

        double caloriesPerGram = totalCalories / totalGrams;

        double pureCalories = caloriesPerGram - (caloriesPerGram * waterPercent / 100);

        System.out.printf("%.4f", pureCalories);


    }
}
