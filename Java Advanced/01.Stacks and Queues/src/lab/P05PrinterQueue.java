package lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                String output = printerQueue.isEmpty()
                        ? "Printer is on standby"
                        : "Canceled " + printerQueue.poll();
                System.out.println(output);
            }else {
                printerQueue.offer(input);
            }

            input = scanner.nextLine();
        }
        for (String s : printerQueue) {
            System.out.println(printerQueue.poll());
        }
    }
}
