package lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = ".idea/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        int bytes = inputStream.read(); //добавяме Exception, направо в мейн метод, премахвайки try/catch

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');
        while (bytes != -1) {
            char symbol = (char)bytes;

            boolean isPunctuation = punctuationTable.contains(symbol);

            if (!isPunctuation) {
                outputStream.write(symbol);
            }

            bytes = inputStream.read();
        }
        System.out.println();
    }
}
