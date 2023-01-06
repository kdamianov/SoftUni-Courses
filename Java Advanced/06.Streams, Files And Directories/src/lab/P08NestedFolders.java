package lab;

import java.io.File;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) {

        //File класът ни дава възможност да използваме даден файл, като такъв в кода, а не като Stream!!!!

        String address = ".idea/resources/Files-and-Streams";

        File root = new File(address); //зареждаме конкретният файл като такъв!!!

        ArrayDeque<File> dirs = new ArrayDeque<>();//съзадваме опашка от всички файлове

        dirs.offer(root);

        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll(); // изкарваме съответният директория
            File[] nestedFiles = current.listFiles(); //добавяме я в масив, за обхождане
            for (File file : nestedFiles) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                }
            }
            count ++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
