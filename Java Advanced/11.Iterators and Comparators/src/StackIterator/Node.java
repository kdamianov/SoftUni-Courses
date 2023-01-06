package StackIterator;

public class Node<Integer> {
    public int element;
    public Node<Integer> prev;

    public Node(int currentElement) {
        this.element = currentElement;
        this.prev = null;
    }
}
