package exercise;

import java.io.File;
import java.util.ArrayDeque;
//НЕ РАБОТИ!!!
public class P08GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("resourcesExercise");

        ArrayDeque <File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumOFBytes = 0;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] files = current.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOFBytes += files.length;
                }
            }
        }
        System.out.printf("Folder size: %d", sumOFBytes);
    }
}
