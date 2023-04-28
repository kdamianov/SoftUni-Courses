package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(E element) {
            this.value = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> nextElement = new Node<>(element);
        nextElement.next = this.head;
        this.head = nextElement;

        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> last = new Node<>(element);

        if (isEmpty()) {
            this.head = last;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = last;
        }
        this.size++;
//        Node<E> last = new Node<>(element);
//
//        if (isEmpty()) {
//            this.head = last;
//        } else {
//            Node<E> current = this.head;
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = last;
//        }
//        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty();

        E value = this.head.value;
        this.head = this.head.next;
        size--;

        return value;
//        ensureNonEmpty();
//
//        E value = this.head.value;
//        this.head = this.head.next;
//        this.size--;
//
//        return value;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();

        if (this.size == 1) {
            E value = this.head.value;
            this.head = null;

            return value;
        }

        Node<E> preLast = this.head;
        Node<E> toRemove = this.head.next;
        while (toRemove.next != null) {
            preLast = toRemove;
            toRemove = toRemove.next;
        }
        preLast.next = null;
        size--;

        return toRemove.value;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();
        return this.head.value;
    }

    @Override
    public E getLast() {
        ensureNonEmpty();

        Node<E> current = this.head;

        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;

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
