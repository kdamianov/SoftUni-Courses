package Exercise;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List <String> listSeparatedByPipe = Arrays.stream(input.split("\\|")).collect(Collectors.toList());

        Collections.reverse(listSeparatedByPipe); // [1 2 3 |4 5 6 |  7  8]-->{"  7  8","4 5 6 ","1 2 3 "}

        System.out.println(listSeparatedByPipe.toString() //"[  7  8, 4 5 6 , 1 2 3 ]
                .replace("]", "")//   7  8, 4 5 6 , 1 2 3 ]
                .replace("[", "") //  7  8, 4 5 6 , 1 2 3
                .trim()                            // 7  8, 4 5 6 , 1 2 3
                .replaceAll(",", "") // 7  8 4 5 6  1 2 3
                .replaceAll("\\s+", " ")); // 7 8 4 5 6 1 2 3 --> премахва всички интервали "s+", които са 1 или повече
    }
}
