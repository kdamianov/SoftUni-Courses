import java.util.Arrays;
import java.util.Scanner;

public class PipesInPool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред съдържа числото V – Обем на басейна в литри – цяло число в интервала [1…10000].
        int v = Integer.parseInt(scanner.nextLine());
        //•	Вторият ред съдържа числото P1 – дебит на първата тръба за час – цяло число в интервала [1…5000].
        int p1 = Integer.parseInt(scanner.nextLine());
        //•	Третият ред съдържа числото P2 – дебит на втората тръба за час– цяло число в интервала [1…5000].
        int p2 = Integer.parseInt(scanner.nextLine());
        //•	Четвъртият ред съдържа числото H – часовете които работникът отсъства – реално число в интервала
        double h = Double.parseDouble(scanner.nextLine());

        double volP1 = p1 * h;
        double volP2 = p2 * h;
        double ttlVol = volP1 + volP2;

        if (ttlVol <= v) {
            volP1 = volP1 / ttlVol * 100;
            volP2 = volP2 / ttlVol * 100;
            ttlVol = ttlVol / v * 100;

            System.out.printf("The pool is %.2f", ttlVol);
            System.out.print("% full. ");
            System.out.printf("Pipe 1: %.2f", volP1);
            System.out.print("%. ");
            System.out.printf("Pipe 2: %.2f", volP2);
            System.out.print("%.");
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, ttlVol - v);
        }
    }
}
