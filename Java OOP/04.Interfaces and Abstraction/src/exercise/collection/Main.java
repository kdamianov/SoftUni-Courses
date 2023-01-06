package exercise.collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        String[] words = scanner.nextLine().split("\\s+");
        int numberRemoveOperation = Integer.parseInt(scanner.nextLine());

        performAddOperations(words, addCollection);
        performAddOperations(words, addRemoveCollection);
        performAddOperations(words, myListImpl);

        performRemoveOperations(numberRemoveOperation, addRemoveCollection);
        performRemoveOperations(numberRemoveOperation, myListImpl);

    }
    public static void performRemoveOperations(int counter, AddRemovable addRemovable){
        for (int i = 0; i < counter; i++) {
            System.out.print(addRemovable.remove());
        }
        System.out.println();
    }
    public static void performAddOperations(String[] words, Addable addable){
        for (String word : words) {
            addable.add(word);
            System.out.print(addable.add(word) + " ");
        }
        System.out.println();
    }
}
