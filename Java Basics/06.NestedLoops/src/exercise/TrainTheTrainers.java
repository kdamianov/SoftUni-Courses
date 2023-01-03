package exercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // брой жури

        String command = scanner.nextLine();

        int countAllGrades = 0;
        double allGradesSum = 0;

        while (!command.equals("Finish")) {
            String presentation = command;
            double sumCurrentGrade = 0;
           for (int i = 1; i <= n; i++) { // n = брой жури ==> толкова оценки
               double currentGrade = Double.parseDouble(scanner.nextLine());// оценка на всеки един от журито
               sumCurrentGrade = sumCurrentGrade + currentGrade;
               countAllGrades++;

            }
           allGradesSum = allGradesSum + sumCurrentGrade;
            double avgCurrGrade = sumCurrentGrade / n;

            System.out.printf("%s - %.2f.%n", presentation, avgCurrGrade);


            command = scanner.nextLine();

        }
        double allGradesAvg = allGradesSum / countAllGrades;

        System.out.printf("Student's final assessment is %.2f.", allGradesAvg);

    }
}
