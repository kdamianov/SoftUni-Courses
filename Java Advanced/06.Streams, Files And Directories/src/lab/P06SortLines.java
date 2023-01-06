package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        String address = ".idea/resources/input.txt";

        Path path = Paths.get(address);

        List<String> lines = Files.lines(path)
                .sorted()
                .collect(Collectors.toList()); // създаваме List  с редовете, които трябва да прочете

        Files.write(Paths.get(".idea/resources/06.SortLinesOutput.txt"), lines); //къде трябва да ги отпечата
        // Files - дава методи за работа с файлове!!!!!! Не е File class!!!!

    }
}
//ТЕЗИ МЕТОДИ НЕ СА ОПТИМАЛНИ ЗА ГОЛЕМИ ФАЙЛОВЕ!!!!!!
