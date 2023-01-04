package moreExercise;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int i = 0; i < input ; i++) {
            String number = scanner.nextLine();

            int digitLenght = number.length();
            int mainDigit = number.charAt(0);

            if (mainDigit == '2') {
                if (digitLenght == 1) {
                    message += "a";
                } else if (digitLenght == 2) {
                    message += "b";
                }else if (digitLenght == 3) {
                    message += "c";
                }
            } else if (mainDigit == '3') {
                if (digitLenght == 1) {
                    message += "d";
                } else if (digitLenght == 2) {
                    message += "e";
                } else if (digitLenght == 3) {
                    message += "f";
                }
            } else if (mainDigit == '4') {
                if (digitLenght == 1) {
                    message += "g";
                } else if (digitLenght == 2) {
                    message += "h";
                } else if (digitLenght == 3) {
                    message += "i";
                }
            } else if (mainDigit == '5') {
                if (digitLenght == 1) {
                    message += "j";
                } else if (digitLenght == 2) {
                    message += "k";
                } else if (digitLenght == 3){
                    message += "l";
                }
            } else if (mainDigit == '6') {
                if (digitLenght == 1) {
                    message += "m";
                } else if (digitLenght == 2) {
                    message += "n";
                } else if (digitLenght ==3) {
                    message += "o";
                }
            } else if (mainDigit == '7') {
                if (digitLenght == 1) {
                    message += "p";
                } else if (digitLenght == 2) {
                    message += "q";
                } else if (digitLenght == 3) {
                    message += "r";
                } else if (digitLenght == 4) {
                    message += "s";
                }
            } else if (mainDigit == '8') {
                if (digitLenght == 1) {
                    message += "t";
                } else if (digitLenght == 2) {
                    message += "u";
                } else if (digitLenght == 3) {
                    message += "w";
                }
            } else if (mainDigit == '9') {
                if (digitLenght == 1) {
                    message += "w";
                } else if (digitLenght == 2) {
                    message += "x";
                } else if (digitLenght == 3) {
                    message += "y";
                } else if (digitLenght == 4 ) {
                    message += "z";
                }
            } else if (mainDigit == '0') {
                message += " ";
            }

        }
        System.out.println(message);
    }
}
