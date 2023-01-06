package lab;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {

        //File класът ни дава възможност да използваме даден файл, като такъв в кода, а не като Stream!!!!

        String address = ".idea/resources/Files-and-Streams";

        File file = new File(address); //зареждаме конкретният файл като такъв!!!

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }


    }
}
