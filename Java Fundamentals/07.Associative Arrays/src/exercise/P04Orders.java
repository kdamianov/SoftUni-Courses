package exercise;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPriceMap = new LinkedHashMap<>();
        Map<String, Integer> productQuantityMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            productPriceMap.put(product, price);

            if (!productQuantityMap.containsKey(product)) {
                productQuantityMap.put(product, quantity);
            } else {
                productQuantityMap.put(product, productQuantityMap.get(product) + quantity);
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
            String productName = entry.getKey();
            double finalPrice = entry.getValue() * productQuantityMap.get(productName);

            System.out.printf("%s -> %.2f%n", productName, finalPrice);
        }

    }
}
