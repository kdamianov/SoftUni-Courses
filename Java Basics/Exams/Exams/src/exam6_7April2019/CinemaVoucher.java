package exam6_7April2019;

import java.util.Scanner;

public class CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucherValue = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        int ticket = 0;
        int other = 0;
        int ticketPrice = 0;
        int otherPrice = 0;
        boolean notEnough = false;

        while (!command.equals("End")) {
            int length = command.length();

            if (length > 8) {

                ticketPrice = command.charAt(0) + command.charAt(1);
                if (ticketPrice > voucherValue){
                    notEnough = true;
                    break;
                }
                ticket ++;
                voucherValue = voucherValue - ticketPrice;
            } else {
                otherPrice = command.charAt(0);
                if (voucherValue < otherPrice) {
                    notEnough = true;
                    break;
                }
                other ++;
                voucherValue = voucherValue - otherPrice;
            }


            command = scanner.nextLine();
        }

        if (notEnough) {
            System.out.println(ticket);
            System.out.println(other);
        } else {
            System.out.println(ticket);
            System.out.println(other);
        }

    }

}
