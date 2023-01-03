import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	На първия ред са необходимите часовете – цяло число в интервала [0 ... 200 000]
        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        //•	На втория ред са дните, с които фирмата разполага – цяло число в интервала [0 ... 20 000]
        int days = Integer.parseInt(scanner.nextLine());
        //•	На третия ред е броят на служителите, работещи извънредно – цяло число в интервала [0 ... 200]
        int employeesWorkingOverTime = Integer.parseInt(scanner.nextLine());

        double finalDays = days - (days * 0.10);
        double ttlHours = finalDays * 8;
        int addHours = employeesWorkingOverTime * (days * 2);
        double finalHours = Math.floor(ttlHours + addHours);
        double diff = Math.abs(finalHours - hoursNeeded);

        if (finalHours >= hoursNeeded) {
            System.out.printf("Yes!%.0f hours left.", Math.floor(diff));
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", Math.floor(diff));
        }
    }
}
