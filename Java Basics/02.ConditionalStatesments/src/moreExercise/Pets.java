import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – брой дни – цяло число в интервал [1…5000]
        int days = Integer.parseInt(scanner.nextLine());
        //•	Втори ред – оставена храна в килограми – цяло число в интервал [0…100000]
        int foodLeft = Integer.parseInt(scanner.nextLine());
        //•	Трети ред – храна на ден за кучето в килограми – реално число в интервал [0.00…100.00]
        double dogFoodInKg = Double.parseDouble(scanner.nextLine());
        //•	Четвърти ред – храна на ден за котката в килограми– реално число в интервал [0.00…100.00]
        double catFoodInKg = Double.parseDouble(scanner.nextLine());
        //•	Пети ред – храна на ден за костенурката в грамове – реално число в интервал [0.00…10000.00]
        double turtleFoodInGrams = Double.parseDouble(scanner.nextLine());

        //храната на кучето за целия период
        double dogFoodPerPeriod = days * dogFoodInKg;
        //hranata za kotkata za celiq period
        double catFoodPerPeriod = days * catFoodInKg;
        //hranata za kostenurkata za celiq period V KG!!!
        double turtleFoodPerPEriod = (days * turtleFoodInGrams) / 1000;
        //obshto hrana za celiq period v kg
        double ttlFoodPerPeriod = dogFoodPerPeriod + catFoodPerPeriod + turtleFoodPerPEriod;

        if (foodLeft >= ttlFoodPerPeriod) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft - ttlFoodPerPeriod));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(ttlFoodPerPeriod - foodLeft));
        }

    }
}
