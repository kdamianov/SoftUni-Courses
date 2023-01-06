package lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = ".idea/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        while(scanner.hasNext()) { //метод: докато има следващи елементи
            if (scanner.hasNextInt()) { //метод: ако следващият елемент е Integer
                System.out.println(scanner.nextInt());
            } else {
                scanner.next(); //метод: преместаване на следващият символ
            }
        }


    }
}
