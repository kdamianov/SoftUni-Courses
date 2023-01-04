package ME05ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsNum = Integer.parseInt(scanner.nextLine());//брой студенти
        int ttlNumLectures  = Integer.parseInt(scanner.nextLine());//общ брой лекции
        int addBonus = Integer.parseInt(scanner.nextLine());//доп. бонус
        double maxBonus = 0;
        double maxAtt = 0;

        for (int student = 1; student <= studentsNum; student++) {
            double studentAttendancies = Double.parseDouble(scanner.nextLine());//the count of attendances for each student.
            double ttlBonus = studentAttendancies / ttlNumLectures * (5 + addBonus);
            if (ttlBonus >= maxBonus) {
                maxBonus = ttlBonus;
            }
            if (studentAttendancies >= maxAtt) {
                maxAtt = studentAttendancies;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %.0f lectures.%n", maxAtt);

    }
}
