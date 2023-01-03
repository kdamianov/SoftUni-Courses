package retakeExam2_3May2019;

import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double countI2 = 0;
        double countI3 = 0;
        double countI4 = 0;


        for (int i = 1; i <= n ; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            if (currentNum % 2 == 0) {
                countI2++;
            }
            if (currentNum % 3 == 0) {
                countI3++;
            }
            if (currentNum % 4 ==0) {
                countI4++;
            }

        }


        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%",countI2/n * 100, countI3/n *100, countI4/n * 100);
    }
}
