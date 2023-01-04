package exercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String first = input[0];
        String second = input[1];

        long sum = calculateSum(first, second);

        System.out.println(sum);

    }
    public static long calculateSum (String first, String second) {

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        long sum = 0;

        int smallerLength = Math.min(firstArr.length, secondArr.length);
        int biggerLength = Math.max(firstArr.length, secondArr.length);

        for (int i = 0; i < smallerLength; i++) {
            sum += (long) firstArr[i] * secondArr[i];
        }

        if (biggerLength == firstArr.length) {
            for (int i = smallerLength; i < biggerLength; i++) {
                sum += firstArr[i];
            }
        } else {
            for (int i = smallerLength; i < biggerLength; i++) {
                sum += secondArr[i];
            }

        }
        return sum;
    }
}
