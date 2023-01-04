package exercise;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Брой страници в текущата книга
        int pagesNumber = Integer.parseInt(scanner.nextLine());

        //Страници, които прочита за 1 час
        int pagesPerHour = Integer.parseInt(scanner.nextLine());

        //Броят на дните, за които трябва да прочете книгата
        int daysToRead = Integer.parseInt(scanner.nextLine());

        //Общо време за четене на книгата: 212 страници / 20 страници за час = 10 часа общо
        //Необходимите часове на ден: 10 часа / 2 дни = 5 часа на ден

        int totalTime = pagesNumber / pagesPerHour;
        int hoursPerDay = totalTime / daysToRead;


        System.out.println(hoursPerDay);


    }
}
