package lab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = ".idea/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//буфериран поток, за който трябва нов InputStreamReader

        FileOutputStream outputStream = new FileOutputStream(".idea/resources/05.WriteEveryThirdLineOutput.txt");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = reader.readLine(); //чете нов ред

        int lineCounter = 1; //за да броим редовете, тк ни трябва всеки 3и

        while (line != null) {
            if (lineCounter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            line = reader.readLine();
            lineCounter++;

        }
        reader.close();
        writer.flush(); //пуска всичко, натрупано в BufferedWriter, еквивалентно е с .close() метод, тк извиква flush
    }
}
