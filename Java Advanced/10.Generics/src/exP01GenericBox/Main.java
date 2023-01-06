package exP01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box();
        for (int i = 0; i < n; i++) {
            Double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }
//        String[] indices = scanner.nextLine().split("\\s+");
//        int firstIndex = Integer.parseInt(indices[0]);
//        int seciondIndex = Integer.parseInt(indices[1]);
//
//        box.swap(firstIndex, seciondIndex);

        Double elementToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countOfGreaterItems(elementToCompare));
    }

}
