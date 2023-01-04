package FE04ProgrammingFundamentalsFinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//100/100 В JUDGE!!!


public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(@#+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";

        for (int i = 1; i <= n; i++) {
            String barcode = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String validBarcode = matcher.group("barcode");
                String group = "";

                for (char c : validBarcode.toCharArray()) {
                    if (Character.isDigit(c)) {
                        group = group + c;
                    }
                }
                if (group.isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", group);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
