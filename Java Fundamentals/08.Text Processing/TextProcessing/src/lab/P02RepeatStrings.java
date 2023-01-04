package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr = scanner.nextLine().split(" ");
        //hi abc add
        List<String> repeatList = new ArrayList<>();
        for (int i = 0; i < stringArr.length; i++) {
            String currentWord = stringArr[i];
            int length = currentWord.length();

            String repeatWord = repeatString(currentWord, length);
            repeatList.add(repeatWord);
        }
        System.out.println(String.join("", repeatList));

    }
    public static String repeatString (String s, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += s;
        }
        return result;
    }
}
