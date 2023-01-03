package retakeExam2_3May2019;

import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String contractPeriod = scanner.nextLine();
        String contractType = scanner.nextLine();
        String mobileNet = scanner.nextLine();
        int monthsToPay = Integer.parseInt(scanner.nextLine());
        double tax = 0;

        if (contractType.equals("Small") && contractPeriod.equals("one")) {
            tax = 9.98;
        } else if (contractType.equals("Small") && contractPeriod.equals("two")) {
            tax = 8.58;
        } else if (contractType.equals("Middle") && contractPeriod.equals("one")) {
            tax = 18.99;
        } else if (contractType.equals("Middle") && contractPeriod.equals("two")) {
            tax = 17.09;
        } else if (contractType.equals("Large") && contractPeriod.equals("one")) {
            tax = 25.98;
        } else if (contractType.equals("Large") && contractPeriod.equals("two")) {
            tax = 23.59;
        } else if (contractType.equals("ExtraLarge") && contractPeriod.equals("one")) {
            tax = 35.99;
        } else if (contractType.equals("ExtraLarge") && contractPeriod.equals("two")) {
            tax = 31.79;
        }

        if (mobileNet.equals("yes") && tax <= 10) {
            tax = tax + 5.50;
        } else if (mobileNet.equals("yes") && tax <= 30) {
            tax = tax + 4.35;
        } else if (mobileNet.equals("yes") && tax > 30) {
            tax = tax + 3.85;
        }

        double ttl = tax * monthsToPay;

        if (contractPeriod.equals("two")) {
            ttl = ttl - (ttl * 3.75/100);
        }

        System.out.printf("%.2f lv.", ttl);
    }
}
