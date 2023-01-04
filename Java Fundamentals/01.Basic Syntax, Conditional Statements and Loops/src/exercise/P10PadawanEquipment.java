package exercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amount = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double ttlSabers = Math.ceil(students + 0.10*students) * lightSaberPrice;
        double ttlRobes = students * robePrice;
        double ttlBelts = (students - students / 6) * beltPrice;

        double ttlSum = ttlSabers + ttlRobes + ttlBelts;

        if (ttlSum <= amount) {
            System.out.printf("The money is enough - it would cost %.2flv.", ttlSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", ttlSum - amount);
        }
    }
}
