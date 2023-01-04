package exercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //A12b s17G
        String[] codes = input.split("\\s+"); //\\s+ - с един или повече("+") интервали


        //сума от числата на всички кодове
        double totalSum = 0;
        for (String code : codes) {
            //код: {буква}{число}{буква}
            //пресмятане на числата
            double number = getModifiedNumber(code);
            //добавяме number към totalSum
            totalSum += number;
        }
        System.out.printf("%.2f", totalSum);
    }
    public static double getModifiedNumber (String code) {
        //код: {буква}{число}{буква}
        char firstLetter = code.charAt(0);
        char lastLetter = code.charAt(code.length() - 1);

        double number = Double.parseDouble(code.replace(firstLetter, ' ').
                replace(lastLetter,' ').
                trim());//.trim премахва излишните празни полета (" ").

        //проверки за 1та буква
        //може и проверка в диапазните за съответната буква в ASCII таблицата
        if (Character.isUpperCase(firstLetter)) {
            int positionLetter = (int) firstLetter - 64;
            number /= positionLetter;
        }else if (Character.isLowerCase(firstLetter)) {
            int positionLetter = (int) firstLetter - 96;
            number *= positionLetter;
        }
        //проверки за 2та буква
        if (Character.isUpperCase(lastLetter)) {
            int positionLetter = (int) lastLetter - 64;
            number -= positionLetter;
        }else if (Character.isLowerCase(lastLetter)) {
            int positionLetter = (int) lastLetter - 96;
            number += positionLetter;
        }
        return number;
    }
}
