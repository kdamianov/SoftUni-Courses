package lab;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = ".idea/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter printer = new PrintWriter(outputStream); //printer Обект, ако искаме да форматираме стрийма

        int bytes = inputStream.read(); //добавяме Exception, направо в мейн метод, премахвайки try/catch

        Set<Integer> delimeterTable = Set.of(10, 32); //стойности в ASCII таблицата

        while (bytes != -1) {


            boolean isDelimeter = delimeterTable.contains(bytes);

            if (isDelimeter) {
                printer.print((char) bytes); //за да го отпечата като символи, а не байтове

            } else {
                printer.print(bytes);
            }

            bytes = inputStream.read();
        }
        System.out.println();

        inputStream.close();
        outputStream.close();
    }
}
