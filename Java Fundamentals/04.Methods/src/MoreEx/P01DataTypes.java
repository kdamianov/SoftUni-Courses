package MoreEx;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String content = scanner.nextLine();
        switch (command) {
            case "int":
                int contentInt = Integer.parseInt(content);
                System.out.println(printResult(contentInt));
                break;
            case "real":
                double contentDouble = Double.parseDouble(content);
                System.out.printf("%.2f", printResult(contentDouble));
                break;
            case "string":
                System.out.println(printResult(content));
                break;
        }
    }
    public static int printResult (int input) {
        return input * 2;
    }
    public static double printResult (double input) {
        return input * 1.5;
    }
    public static String printResult (String input) {
        return "$" + input + "$";
    }
}
