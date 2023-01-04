package FE02ProgrammingFundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 100 / 100 в Judge!!!
public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> destinations = new ArrayList<>();
        int totalTravelPoints = 0;

        while (matcher.find()) {
            String destination = matcher.group("destination");
            destinations.add(destination);
            int travelPoints = destination.length();
            totalTravelPoints += travelPoints;
        }
        String destinationsToPrint = String.join(", ", destinations);
        System.out.printf("Destinations: %s%n", destinationsToPrint);
        System.out.printf("Travel Points: %d%n", totalTravelPoints);
    }
}
