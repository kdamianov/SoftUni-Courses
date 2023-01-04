package exercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //"abv>1>1>2>2asdasd"
        //">" - експлозия
        //"число" - сила на експлозия
        int totalStrength = 0;
        StringBuilder text = new StringBuilder(input);
        for (int position = 0; position < text.length(); position++) {
            char currentSymbol = text.charAt(position);
            //експлозия ">"
            if (currentSymbol == '>') {
                //char '1' -> text "1" -> int 1
                int explosionStrength = Integer.parseInt(text.charAt(position + 1) + "");
                //ако има още сила, при триене на символи
                totalStrength += explosionStrength;
            } else if (currentSymbol != '>' && totalStrength > 0) {
                //премахване
                text.deleteCharAt(position);
                //намаляме силата
                totalStrength --;
                //връщаме се на позиция назад, спрямо силата
                position --;
            }
        }
        System.out.println(text);
    }
}
