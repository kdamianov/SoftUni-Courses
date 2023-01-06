package exercise;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("resourcesExercise/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("resourcesExercise/output.txt"));
        String line = br.readLine();
        int counter = 1;
         while (line != null) {
             pw.println(counter + ". " + line);
              counter ++;
              line = br.readLine();
         }
         br.close();
         pw.close();
    }
}
