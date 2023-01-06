package exercise;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "resourcesExercise/input.txt";

        PrintWriter pw = new PrintWriter(new PrintWriter("resourcesExercise/output.txt"));
        BufferedReader br = new BufferedReader(new FileReader(path));

        br.lines().forEach(line -> pw.println(line.toUpperCase()));
        br.close();
        pw.close();
    }
}
