package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) throws IOException, IOException {

//при работа с Characters е по-добре да се работи с Filereader, a не с FileInputStream

        String path = "resourcesExercise/input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = bufferedReader.readLine();

        while (line != null) {
            long sum = 0;
            char[] characterFromLine = line.toCharArray();
            for (char character : characterFromLine) {
                sum += character;
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
