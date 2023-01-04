package exercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int position = 0; position <= text.length() - 1; position++) {
            char symbol = text.charAt(position);
            char encryptedSymbol= (char)(symbol + 3);//пояснява се да даде символ, а не стойността
            encryptedText.append(encryptedSymbol);//добавяме всеки един символ
        }
        System.out.println(encryptedText);
        //System.out.println((int) 'a'); - принтира стойността на символа !!!
        //System.out.println((char) 65); - принтира символът с тази стойност !!!
    }
}
