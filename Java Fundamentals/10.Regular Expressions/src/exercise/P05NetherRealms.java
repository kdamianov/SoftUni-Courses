package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonNames = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).
                collect(Collectors.toList());
        //name: M3ph-0.5s-0.5t0.0**
        //health = sum(ASCII codes) of all charachters (excl 0-9,'+', '-', '*', '/','.'
        //damage = sum of all numbers (incl + or - )
        //if * or / -> multily or divide by 2 after all numbers ar included
        Pattern patternHealth = Pattern.compile("[^0-9+\\-*\\/.]");
        Pattern patternDamage = Pattern.compile("\\-?\\+?[0-9]+[\\.]?[0-9]*");

        for (String demon: demonNames) {
            Matcher matcherHealth = patternHealth.matcher(demon);
            int health = 0;
            while (matcherHealth.find()) {
                char symbol = matcherHealth.group().charAt(0);
                health += symbol;
            }

            Matcher matcherDamage = patternDamage.matcher(demon);
            double damage = 0.0;
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group());
            }
            for (char symbol : demon.toCharArray()) {
                if (symbol == '/'){
                    damage /= 2;
                }else if (symbol == '*'){
                    damage *= 2;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }
}
