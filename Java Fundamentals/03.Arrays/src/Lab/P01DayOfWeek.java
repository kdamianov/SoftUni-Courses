package Lab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"};

        int num = Integer.parseInt(scanner.nextLine());

        if (num >=1 && num <=7) {
            System.out.println(daysOfWeek[num - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
