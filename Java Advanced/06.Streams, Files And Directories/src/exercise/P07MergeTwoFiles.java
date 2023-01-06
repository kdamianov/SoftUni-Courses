package exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

//        BufferedWriter bufferedReader =
//                new BufferedWriter(new FileWriter("resourcesExercise/output.txt", true));
//         bufferedReader.write();
//        appednmode!!!!

        Path firstFile = Paths.get("resourcesExercise/inputOne.txt");
        List<String> firstFIleLines = Files.readAllLines(firstFile);
        for (String firstFIleLine : firstFIleLines) {
            System.out.println(firstFIleLine);
        }

        Path secondFile = Paths.get("resourcesExercise/inputTwo.txt");
        List<String> secondFIleLines = Files.readAllLines(secondFile);

        Path output = Paths.get("resourcesExercise/output.txt");
        Files.write(output, firstFIleLines, StandardOpenOption.APPEND);
        Files.write(output, secondFIleLines, StandardOpenOption.APPEND);

    }
}
