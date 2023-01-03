import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Брой магнолии – цяло число в интервала [0 … 50]
        int magnolias = Integer.parseInt(scanner.nextLine());
        //•	Брой зюмбюли – цяло число в интервала [0 … 50]
        int hyacinths = Integer.parseInt(scanner.nextLine());
        //•	Брой рози – цяло число в интервала [0 … 50]
        int roses = Integer.parseInt(scanner.nextLine());
        //•	Брой кактуси – цяло число в интервала [0 … 50]
        int cacti = Integer.parseInt(scanner.nextLine());
        //•	Цена на подаръка – реално число в интервала [0.00 … 500.00]
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double ttlProfit = (magnolias * 3.25 + hyacinths * 4 + roses * 3.50 + cacti * 8) * 0.95;

        if (ttlProfit >= giftPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(ttlProfit - giftPrice));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(giftPrice - ttlProfit));
        }
    }
}
