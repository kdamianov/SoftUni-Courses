package preExam9and10April2022;

import java.util.Scanner;

public class SumAndProduct_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean comb = false;


        for (int a = 1; a <= 9; a++) {
            for (int b = 9; b >= a; b--) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 9; d >= c; d--) {

                        int sum = a + b + c + d;
                        int mult = a * b * c * d;

                        if ((sum == mult) && (n % 10 == 5)) {
                            comb = true;
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                            break;

                        } else if ((mult / sum == 3) && (n % 3 == 0)) {
                            comb = true;
                            System.out.printf("%d%d%d%d ", d, c, b, a);
                            break;
                        }
                    } if (comb) {
                        break;
                    }
                }
            }
        }
        if (!comb) {
            System.out.println("Nothing found");
        }
    }
}





