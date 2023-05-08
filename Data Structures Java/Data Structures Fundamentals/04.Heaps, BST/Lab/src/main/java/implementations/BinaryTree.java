package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> leftChild, BinaryTree<E> rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder sb = new StringBuilder();
        String padding = createPadding(indent) + this.getKey();
        sb.append(padding);

        if (this.getLeft() != null) {
            String preOrder = this.getLeft().asIndentedPreOrder(indent + 2);//извикваме рекурсия за leftChild
            sb.append(System.lineSeparator()).append(preOrder);
        }

        if (this.getRight() != null) {
            String preOrder = this.getRight().asIndentedPreOrder(indent + 2);//извикваме рекурсия за rightChild
            sb.append(System.lineSeparator()).append(preOrder);
        }

        return sb.toString();
    }

    private String createPadding(int indent) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this); //добавяме текущото binary Tree

        if (this.getLeft() != null) {
            result.addAll(this.getLeft().preOrder()); // ако има leftChild, продължаваме надолу
        }
        if (this.getRight() != null) {
            result.addAll(this.getRight().preOrder()); // ако има rightChild, продължаваме надолу
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (this.getLeft() != null) {
            result.addAll(this.getLeft().inOrder()); // ако има leftChild, продължаваме надолу
        }

        result.add(this); //добавяме текущото binary Tree

        if (this.getRight() != null) {
            result.addAll(this.getRight().inOrder()); // ако има rightChild, продължаваме надолу
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (this.getLeft() != null) {
            result.addAll(this.getLeft().postOrder()); // ако има leftChild, продължаваме надолу
        }
        if (this.getRight() != null) {
            result.addAll(this.getRight().postOrder()); // ако има rightChild, продължаваме надолу
        }
        result.add(this); //добавяме текущото binary Tree

        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (this.getLeft() != null) {
            this.getLeft().forEachInOrder(consumer);
        }
        consumer.accept(this.getKey());

        if (this.getRight() != null) {
            this.getRight().forEachInOrder(consumer);
        }
    }
}
