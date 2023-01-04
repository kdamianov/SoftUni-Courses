package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>(); //списък с мебели
        double totalSum = 0; //обща похарчена сума
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        // />>(?<furnitureName>\\w+)<<(?<price>\\d+.?\\d*)!(?<quantity>\\d+)/ - Може и така!!!
        Pattern pattern = Pattern.compile(regex);
        while (!input.equals("Purchase")) {
        //">>{furniture name}<<{price}!{quantity}" - валиден ред!!!
        //input = ">>Sofa<<312.23!3"
            Matcher matcher = pattern.matcher(input);
            //find -> функционалност
            //true -> input отговаря на regex
            if (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furniture.add(furnitureName);
                double currentFurniturePrice = price * quantity;
                totalSum += currentFurniturePrice;
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f%n", totalSum);
    }
}
