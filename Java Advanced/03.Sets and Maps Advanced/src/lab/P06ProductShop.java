package lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, Map <String, Double>> shopMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] inputLine = input.split(", ");
            String shop = inputLine[0];
            String product = inputLine[1];
            double price = Double.parseDouble(inputLine[2]);

            shopMap.putIfAbsent(shop, new LinkedHashMap<>());
            Map <String, Double> productsMap = shopMap.get(shop);
            productsMap.put(product, price);

            input = scanner.nextLine();
        }
        for (String shop : shopMap.keySet()) {
            System.out.println(shop + "->");
            for (String product : shopMap.get(shop).keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, shopMap.get(shop).get(product));
            }
        }
    }
}
