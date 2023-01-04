package Lab;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (operator) {
            case "+":
                System.out.println(getSum(firstNum, secondNum));
                break;
            case "-":
                System.out.println(getSubtraction(firstNum, secondNum));
                break;
            case "*":
                System.out.println(getMultiplication(firstNum, secondNum));
                break;
            case "/":
                System.out.println(getDivision(firstNum,secondNum));
                break;
        }


    }
    public static int getSum (int num1, int num2) {
        return num1 + num2;
    }
    public static int getSubtraction (int num1, int num2) {
        return num1 - num2;
    }
    public static int getMultiplication (int num1, int num2) {
        return num1 * num2;
    }
    public static int getDivision (int num1, int num2) {
        return num1 / num2;
    }

}
