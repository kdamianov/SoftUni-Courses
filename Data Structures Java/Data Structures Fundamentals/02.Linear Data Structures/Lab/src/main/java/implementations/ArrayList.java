package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;


public class ArrayList<E> implements List<E> {
    private static final int INITIAL_SIZE = 4;
    private Object[] elements;
    private int size;
    private int capacity; //колко елемента може да се съхранят

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = INITIAL_SIZE; //първоначално е с такава стойност

    }

    @Override
    public boolean add(E element) {
        if (this.size == this.capacity) {
            grow();
        }
        this.elements[this.size++] = element; //добавяме на индекс, колкото е size и след това увеличаваме size!
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (!validIndex(index)) {
            return false;
        }

        shiftRight(index);
        elements[index] = element;
        this.size++;
        return true;
    }

    @Override
    public E get(int index) {
        ensureIndex(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        ensureIndex(index);

        Object existing = this.elements[index];
        this.elements[index] = element;

        return (E) existing;
    }

    @Override
    public E remove(int index) {
        ensureIndex(index);
        Object existing = this.elements[index];

        shiftLeft(index);
        this.size--;
        shrinkIfNeeded();

        return (E) existing;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (elements[i].equals(element)) { //използваме .equals, тк типът елемент не се знае какъв е!
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return this.indexOf(element) != -1;
        //проверяваме дали се съдържа, чрез горния код
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() { //показваме как може да се обходи структурата!
        return new Iterator<E>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < size();
                //показва, че може да има следващ елемент!С
            }
            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        this.capacity *= 2;
        Object[] tempArr = new Object[this.capacity];//може и new Object[this.capacity * 2]; без да пишем горният ред!

        for (int i = 0; i < this.elements.length; i++) {
            tempArr[i] = this.elements[i];
        }

        this.elements = tempArr;

        // Може и: return Arrays.copyOf(this.elements, this.elements.length * 2);   !!!
    }

    private void shrinkIfNeeded() {
        if (this.size > this.capacity / 3) {
            return;
        }

        this.capacity /= 2;
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private void ensureIndex(int index) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException(
                    "Cannot use index" + index + " on ArrayList with" + this.size + " elements");
        }
    }
}
