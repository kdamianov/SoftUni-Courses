package exercise;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.	Необходимо количество найлон (в кв.м.)
        int plastic = Integer.parseInt(scanner.nextLine());
        //2.	Необходимо количество боя (в литри)
        int paint = Integer.parseInt(scanner.nextLine());
        //3.	Количество разредител (в литри)
        int thinner = Integer.parseInt(scanner.nextLine());
        //4.	Часовете, за които майсторите ще свършат работата
        int workingHours = Integer.parseInt(scanner.nextLine());

        //Сума за найлон: (10 + 2) * 1.50 = 18 лв.
        double sumPlastic = (plastic + 2) * 1.50;
        //Сума за боя: (11 + 10%) * 14.50 = 175.45 лв.
        double sumPaint = (paint + (paint * 0.10)) * 14.50;
        //Сума за разредител: 4 * 5.00 = 20.00 лв.
        double sumThinner = thinner * 5;
        //Сума за торбички: 0.40 лв.
        //Обща сума за материали: 18 + 175.45 + 20.00 + 0.40 = 213.85 лв.
        double ttlSumMaterials = sumPlastic + sumPaint + sumThinner + 0.40;
        //Сума за майстори: (213.85 * 30%) * 8 = 513.24 лв.
        double workerSum = (ttlSumMaterials * 0.30) * workingHours;
        //Крайна сума: 213.85 + 513.24 = 727.09 лв.
        double finalSum = ttlSumMaterials + workerSum;

        System.out.println(finalSum);

    }
}
