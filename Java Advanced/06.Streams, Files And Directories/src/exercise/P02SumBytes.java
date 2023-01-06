package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "resourcesExercise/input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = bufferedReader.readLine();
        long sum = 0;
        while (line != null) {

            char[] characterFromLine = line.toCharArray();
            for (char character : characterFromLine) {
                sum += character;
            }

            line = bufferedReader.readLine();
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
