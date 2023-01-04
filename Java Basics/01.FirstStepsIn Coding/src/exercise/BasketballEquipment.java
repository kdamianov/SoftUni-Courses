package exercise;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //godishna taksa
        int tax = Integer.parseInt(scanner.nextLine());

        //•	Баскетболни кецове – цената им е 40% по-малка от таксата за една година
        double sneakersPrice = tax - (tax * 0.40);

        //•	Баскетболен екип – цената му е 20% по-евтина от тази на кецовете
        double uniformPrice = sneakersPrice - (sneakersPrice * 0.20);

        //•	Баскетболна топка – цената ѝ е 1 / 4 от цената на баскетболния екип
        double ballPrice = uniformPrice / 4;

        //•	Баскетболни аксесоари – цената им е 1 / 5 от цената на баскетболната топка
        double accessories = ballPrice / 5;

        //Обща цена за екипировката

        double totalPrice = tax + sneakersPrice + uniformPrice + ballPrice + accessories;

        System.out.printf("%.2f", totalPrice);


    }
}
