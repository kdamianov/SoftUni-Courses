package ME02ProgrammingFundamentalsMidExam;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPerHour = Integer.parseInt(scanner.nextLine());
        int secondPerHour = Integer.parseInt(scanner.nextLine());
        int thirdPerHour = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        int ttlPerHour = firstPerHour + secondPerHour + thirdPerHour;
        int neededHours = 0;


        while (students > 0) {
            neededHours++;  //adds 1 hour to needed hours
            students -= ttlPerHour; // left students

        if (neededHours % 4 == 0) {  //every 4th hour is a break --> +1 hour
            neededHours++;
        }

        }
        System.out.printf("Time needed: %dh.", neededHours);
    }
}
