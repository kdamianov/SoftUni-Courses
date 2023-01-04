package ME02ProgrammingFundamentalsMidExam;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            //•	"swap {index1} {index2}" - takes two elements and swap their places.
            //•	"multiply {index1} {index2}" - takes element at the 1st index and multiply it
            // with the element at 2nd index. Save the product at the 1st index.
            //•	"decrease" - decreases all elements in the array with 1.
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "swap":
                    int index1 = Integer.parseInt(commandParts[1]);
                    int index2 = Integer.parseInt(commandParts[2]);
                    int element1 = array[index1];
                    int element2 = array[index2];

                    array[index1] = element2;
                    array[index2] = element1;
                    break;
                case "multiply":
                    int indexFirst = Integer.parseInt(commandParts[1]);
                    int indexSecond = Integer.parseInt(commandParts[2]);
                    int elementFirst = array[indexFirst];
                    int elementSecond = array[indexSecond];

                    int product = elementFirst * elementSecond;
                    array[indexFirst] = product;
                    break;
                case "decrease":
                    for (int i = 0; i <= array.length - 1; i++) {
                        array[i] = array[i] - 1;
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        for (int i = 0; i <= array.length -1; i++) {
            if (i!= array.length -1) {
                System.out.print(array[i] + ", ");
            }else {
                System.out.println(array[i]);
            }
        }
    }
}
