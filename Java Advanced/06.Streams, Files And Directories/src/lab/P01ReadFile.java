package lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = ".idea/resources/input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int bytes = fileInputStream.read();

            while (bytes != -1) {

                System.out.print(Integer.toBinaryString(bytes) + " "); //Метод, който превръща

                bytes = fileInputStream.read();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}