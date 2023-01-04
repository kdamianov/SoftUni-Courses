package lab;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String text = scanner.nextLine();
        //ice
        //kicegiciceeb

        int index = text.indexOf(toRemove);
        while (text.contains(toRemove)) {
            text = text.replace(toRemove, "");
        }
        System.out.println(text);
//        while (index != -1) {
//            text = text.replace(toRemove, "");
//
//            index = text.indexOf(toRemove);
//        }
//        System.out.println(text);
    }
}
