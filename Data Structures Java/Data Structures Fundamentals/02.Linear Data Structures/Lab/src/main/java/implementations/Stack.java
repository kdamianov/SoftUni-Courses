package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top; //най-горният елемент
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next; //връзка със следващия елемент

        public Node(E element) {
            this.value = element;
        }
    }

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    @Override
    public void push(E element) {
        Node<E> toInsert = new Node<>(element);
        toInsert.next = this.top;
        this.top = toInsert;

        this.size++;
    }

    @Override
    public E pop() {
        ensureNonEmpty();

        Node<E> temp = this.top;
        this.top = temp.next;
        size--;

        return temp.value;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.top.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E value = this.current.value;
                this.current = this.current.next;

                return value;
            }
        };
    }

    private void ensureNonEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
