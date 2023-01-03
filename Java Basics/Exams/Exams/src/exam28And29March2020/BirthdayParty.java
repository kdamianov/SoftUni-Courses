package exam28And29March2020;

import java.util.Scanner;

public class BirthdayParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());
        //•	Торта  – цената ѝ е 20% от наема на залата
        double cake = rent * 20 / 100;
        //•	Напитки – цената им е 45% по-малко от тази на тортата
        double drinks = cake * 0.55;
        //•	Аниматор – цената му е 1/3 от цената за наема на залата
        double animator = rent / 3;

        double ttl = rent + cake + drinks + animator;

        System.out.println(ttl);

    }
}
