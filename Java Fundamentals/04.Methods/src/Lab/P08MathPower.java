package Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNum = Double.parseDouble(scanner.nextLine());
        double inputPower = Double.parseDouble(scanner.nextLine());

        double result = mathPower(inputNum, inputPower);

        DecimalFormat df = new DecimalFormat("0.#####");
        System.out.println(df.format(result));

    }
    public static double mathPower(double num, double power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= num;
        }
        return result;
    }

}
