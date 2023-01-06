package exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("resourcesExercise/jpeg-home.jpg");
        FileOutputStream fos = new FileOutputStream("resourcesExercise/copy.jpg");

        byte[] buffer = new byte[1024];

        while (fis.read(buffer) >=0 ) {
            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
