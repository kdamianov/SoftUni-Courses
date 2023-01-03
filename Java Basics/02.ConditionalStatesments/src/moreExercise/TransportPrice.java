import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред съдържа числото n – брой километри – цяло число в интервала [1…5000]
        int kilometers = Integer.parseInt(scanner.nextLine());
        //•	Вторият ред съдържа дума “day” или “night” – пътуване през деня или през нощта
        String dayOrNight = scanner.nextLine();

        double price = 0;

        if (kilometers < 20) {
            if (dayOrNight.equals("day")) {
                price = 0.70 + 0.79 * kilometers;
            } else {
                price = 0.70 + 0.90 * kilometers;
            }
        } else if (kilometers <100) {
            price = 0.09 * kilometers;
        } else {
            price = 0.06 * kilometers;
        }
        System.out.printf("%.2f", price);
    }
}
