package finalExamPrep02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(inputLine);
        List<String> destionationList = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()){
            String destination = matcher.group("destination");
            destionationList.add(destination);
            travelPoints += destination.length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destionationList));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
