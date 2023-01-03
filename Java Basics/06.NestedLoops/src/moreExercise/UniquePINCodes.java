package moreExercise;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        boolean isNotPrime = false;


        for (int i = 2; i <= n1; i=i+2) {
            for (int j = 1; j <= n2; j++) {
                isNotPrime = false;
                for (int del = 2; del <= j - 1; del++) {
                    if (j % del == 0) {
                        isNotPrime = true;
                        break;
                    }
                }
                if (!isNotPrime && j != 1) {
                    for (int k = 2; k <= n3; k=k+2) {
                            System.out.printf("%d %d %d%n", i, j ,k);
                        }
                    }
                }
            }
        }
    }


