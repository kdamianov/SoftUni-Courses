package moreExercise;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int last = Integer.parseInt(scanner.nextLine());
//•	Ако номерът започва с четна цифра, то той трябва да завършва на нечетна цифра и обратното –
// ако започва с нечетна,  завършва на четна
//•	Първата цифра от номера е по-голяма от последната
//•	Сумата от втората и третата цифра трябва да е четно число

        for (int i = first; i <= last; i++) {
            for (int j = first; j <= last ; j++) {
                for (int k = first; k <= last; k++) {
                    for (int l = first; l <= last ; l++) {
                        int sumJK = j + k;
                        if (i % 2 ==0 && l % 2 !=0 && i > l && sumJK % 2 == 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        } else if (i % 2 !=0 && l % 2 ==0 && i > l && sumJK % 2 == 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }

                }

            }

        }


    }
}
