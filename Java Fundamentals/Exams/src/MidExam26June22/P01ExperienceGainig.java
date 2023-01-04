package MidExam26June22;

import java.util.Scanner;

public class P01ExperienceGainig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int battlesCount = Integer.parseInt(scanner.nextLine());
        double experienceGained = 0;
        int battles = battlesCount;
        int battlesPassed = 0;
        boolean isGained = false;

        while (battles > 0) {
            double experiencePerBattle = Double.parseDouble(scanner.nextLine());
            battlesPassed ++;



            if (battlesPassed % 3 == 0) {
                experiencePerBattle = experiencePerBattle + (experiencePerBattle * 0.15);
            }
            if (battlesPassed % 5 == 0) {
                experiencePerBattle = experiencePerBattle - (experiencePerBattle * 0.10);
            }
            if (battlesPassed % 15 ==0) {
                experiencePerBattle = experiencePerBattle + (experiencePerBattle * 0.05);
            }

            experienceGained += experiencePerBattle;

            if (experienceGained >= neededExperience) {
                isGained = true;
            }
            if (isGained) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", battlesPassed);
                break;
            }

            battles--;
        }
        if (!isGained) {
            if (experienceGained >= neededExperience) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", battlesCount);
            } else {
                System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExperience - experienceGained);
            }
        }
    }
}
