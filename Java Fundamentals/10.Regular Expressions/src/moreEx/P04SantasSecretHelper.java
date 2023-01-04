package moreEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//100/100!!!

public class P04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            StringBuilder decrypted = new StringBuilder();
            for (Character symbol : input.toCharArray()) {
                decrypted.append((char)(symbol - key));
            }
            String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behaviour>[G])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decrypted.toString());
            if (matcher.find()) {
                String name = matcher.group("name");
                System.out.println(name);
            }
            input = scanner.nextLine();
        }
    }
}
