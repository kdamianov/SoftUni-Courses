import implementations.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(6);
        list.add(7);
        list.remove(0);
        System.out.println(list.size());
    }
}
