package exercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        String[] foldersName = path.split("\\\\");
        //escape-ваме с допълнителни наклонени черти, иначе се приема като оператор
        String fullFileName = foldersName[foldersName.length - 1];//Template.pptx

        String fileName = fullFileName.split("\\.")[0];
        String fileExtension = fullFileName.split("\\.")[1];

        System.out.printf("File name: %s%n" +
                "File extension: %s", fileName, fileExtension);
    }
}
